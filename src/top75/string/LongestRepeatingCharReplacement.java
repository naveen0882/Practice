package string;

import java.util.*;

/*
You are given a string s and an integer k. You can choose any character of the string and 
change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.

Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
 */
public class LongestRepeatingCharReplacement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int characterReplacement(String s, int k) {
	    // Space O(26)
	    int[] dic = new int[26];
	    int start = 0;
	    int maxLen = 0;
	    // Time O(n)
	    for (int end = 0; end < s.length(); end++) {
	      maxLen = Math.max(maxLen, ++dic[s.charAt(end) - 'A']);
	      if (end - start + 1 > maxLen + k) {
	        dic[s.charAt(start) - 'A']--;
	        start++;
	      }
	    }
	    return s.length() - start;
	 }
	
	public int characterReplacement2(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        
        for(right = 0; right<s.length(); right++){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0)+1);
            int max = Integer.MIN_VALUE;
            for(int val : map.values()){
                max = Math.max(val, max);
            }
            
            while((right-left+1 - max)>k){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                left++;
            }
            res = Math.max(res, right-left+1);
        }
        
        return res;
    }

}
