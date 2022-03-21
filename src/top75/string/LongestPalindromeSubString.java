package string;

import java.util.*;

/*
Given a string s, return the longest palindromic substring in s.

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:

Input: s = "cbbd"
Output: "bb"
*/
public class LongestPalindromeSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String longestPalindrome(String s) {
		if (s==null || s.length()==1) return s;

		    Map<Character, ArrayList<Integer>> cache = new HashMap<Character, ArrayList<Integer>>();
		    String result = "";
		    
		    for(int i=0; i<s.length(); i++){
		        if(cache.containsKey(s.charAt(i))) {
		            //found duplicate char, check if there's palindromic substring
		            String temp = findPalindrome(s, cache.get(s.charAt(i)), i);
		            result = (temp.length() > result.length()) ? temp : result;
		            ArrayList<Integer> positions = cache.get(s.charAt(i));
		            positions.add(i);
		            cache.put(s.charAt(i), positions);
		        } else {
		            ArrayList<Integer> positions = new ArrayList<Integer>();
		            positions.add(i); 
		            cache.put(s.charAt(i), positions);
		        }    
		     }
		    
		    if (result =="") return s.substring(0,1);
		     return result;
		}

		private String findPalindrome(String s, ArrayList<Integer> arr, int cur){
		    for (int pos:arr) {
		        String temp = s.substring(pos,cur+1);
		        if(isPalindromic(temp)) return temp;
		    }
		    return "";
		}                       

		private Boolean isPalindromic(String s) {
		    int i=0, j=s.length()-1;
		    while (i<j){
		        if (s.charAt(i++)!=s.charAt(j--)) return false;
		    }
		    return true;
		}

}
