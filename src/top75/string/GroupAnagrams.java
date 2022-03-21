package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
typically using all the original letters exactly once.

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:

Input: strs = [""]
Output: [[""]]

Example 3:

Input: strs = ["a"]
Output: [["a"]]
 */
public class GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) {
            return new ArrayList<List<String>>();
        }
        
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        
        Arrays.sort(strs);
        
        for(String s : strs) {
            char[] characters = s.toCharArray();
        
            Arrays.sort(characters);
            
            String key = String.valueOf(characters);
            
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            
            map.get(key).add(s);
        }
        
        return new ArrayList<List<String>>(map.values());
    }

}
