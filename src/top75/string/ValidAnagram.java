package string;

import java.util.Arrays;
import java.util.HashMap;

/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
typically using all the original letters exactly once.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true

Example 2:

Input: s = "rat", t = "car"
Output: false
 */
public class ValidAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int a[] = new int[26];
		for (int i = 0; i < s.length(); i++) {
			a[s.charAt(i) - 'a']++;
			a[t.charAt(i) - 'a']--;
		}

		for (int i = 0; i < a.length; i++) {
			if (a[i] != 0) {
				return false;
			}
		}
		return true;
	}
	
	 public boolean isAnagram3(String s, String t) {
	        
	        int[] sCharCount = new int[26];
	        int[] tCharCount = new int[26];
	        
	        for (char c : s.toCharArray()) {
	            sCharCount[c - 'a'] += 1; 
	        }
	        
	        for (char c : t.toCharArray()) {
	            tCharCount[c - 'a'] += 1; 
	        }
	        
	        return Arrays.equals(sCharCount, tCharCount);
	        
	    }
	
	public boolean isAnagram2(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c: s.toCharArray()) {
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
            else {
                map.put(c, 1);
            }
        }
        
        for(char c: t.toCharArray()) {
            if(map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            }
            else {
                return false;
            }
        }
        
        for(char c: map.keySet()) {
            if(map.get(c) != 0) {
                return false;
            }
        }
        
        return true;
    }

}
