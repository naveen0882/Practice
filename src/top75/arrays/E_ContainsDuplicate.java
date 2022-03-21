package arrays;

import java.util.HashMap;
/*
Given an integer array nums, return true if any value appears at least twice in the array, 
and return false if every element is distinct.

Example 1:

Input: nums = [1,2,3,1]
Output: true

Example 2:

Input: nums = [1,2,3,4]
Output: false

Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
 */
public class E_ContainsDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {7,1,5,3,6,4};
		System.out.println(containsDuplicate(input));
	}
	
	public static boolean containsDuplicate(int[] nums) {
		 HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	        for(int i: nums) {
	            if(map.containsKey(i)) {
	                return true;
	            } else {
	                map.put(i, 1);
	            }
	        }
	        
	        return false;
    }

}
