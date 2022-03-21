package string;

import java.util.HashMap;
import java.util.Map;

/*
Given two strings s and t of lengths m and n respectively, 
return the minimum window substring of s such that every character in t (including duplicates) is included in the window. 
If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

A substring is a contiguous sequence of characters within the string.

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.

Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 */
public class MinWindowSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char c : s.toCharArray()) {
            map.put(c, 0);
        }
        
        for(char c : t.toCharArray()) {
            if(map.containsKey(c)) {
                map.put(c, map.get(c)+ 1);
            } else {
                return "";
            }
        }
        
        int start = 0;
        int end = 0;
        int minStart = 0;
        int minLength = Integer.MAX_VALUE;
        int counter = t.length();
        
        while(end < s.length()) {
            char c1 = s.charAt(end);
            
            if(map.get(c1) > 0) {
                counter--;
            }
            
            map.put(c1, map.get(c1) - 1);
            end++;
            
            while(counter == 0) {
                if(minLength > end - start) {
                    minLength = end - start;
                    minStart = start;
                }
                
                char c2 = s.charAt(start);
                map.put(c2, map.get(c2) + 1);
                
                if(map.get(c2) > 0) {
                    counter++;
                }
                
                start++;
            }
        }
        
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
	}
	
	public String minWindow2(String s, String t) {
        
        Map<Character, Integer> needMap = new HashMap<>();
        Map<Character, Integer> haveMap = new HashMap<>();
        
        int have = 0, startWindow = 0, startIndex = -1, endIndex = -1, minLen = Integer.MAX_VALUE;
        
        for(char ch: t.toCharArray())
            needMap.put(ch, needMap.getOrDefault(ch, 0) + 1);
        
        
        for(int endWindow = 0; endWindow < s.length(); endWindow++) {
            
            char ch = s.charAt(endWindow);
            
            if(needMap.containsKey(ch)) {
                haveMap.put(ch, haveMap.getOrDefault(ch, 0) + 1);
                
                if(haveMap.get(ch).equals(needMap.get(ch)))
                    have++;
                
                while(have == needMap.size()) {
                    int currLen = endWindow - startWindow;
                    if(minLen > currLen) {
                        minLen = currLen;
                        startIndex = startWindow;
                        endIndex = endWindow;
                    }
                    
                    ch = s.charAt(startWindow++);
                    
                    if(haveMap.containsKey(ch)) {
                        haveMap.put(ch, haveMap.get(ch) - 1);
                        
                        if(haveMap.get(ch) < needMap.get(ch))
                            have--;   
                    }
                }
            }
        }
        
        return startIndex == -1? "": s.substring(startIndex, endIndex + 1);
    }

}
