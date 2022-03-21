package string;

import java.util.HashSet;

/*
Given a string s, find the length of the longest substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0, max = 0;
        HashSet<Character> set = new HashSet<>();
        while(end<s.length()){
            if(!set.contains(s.charAt(end))){
                set.add(s.charAt(end));
                end++;
                max = Math.max(max, set.size());
            }
            else{
                set.remove(s.charAt(start));
                start++;
            }
        }
        return max;
    }

}
