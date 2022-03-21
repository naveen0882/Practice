package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] 
such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

Example 2:

Input: nums = []
Output: []

Example 3:

Input: nums = [0]
Output: []
 
*/

public class M_ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> threeSum(int[] nums) {
	     List<List<Integer>>  result = new ArrayList<>();
	     
	     Arrays.sort(nums);
	     
	     for(int i = 0; i < nums.length - 2; i++) {
	         if(i > 0 && nums[i] == nums[i - 1]) {
	             continue;
	         }
	         
	         int j = i + 1;
	         int k = nums.length - 1;
	         int target = -nums[i];
	         
	         while(j < k) {
	             if(nums[j] + nums[k] == target) {
	                 ArrayList<Integer> temp = new ArrayList<Integer>();
	                 
	                 temp.add(nums[i]);
	                 temp.add(nums[j]);
	                 temp.add(nums[k]);
	                 
	                 result.add(temp);
	                 
	                 j++;
	                 k--;
	                 
	                 while(j < k && nums[j] == nums[j - 1]) {
	                     j++;
	                 }
	                 
	                 while(j < k && nums[k] == nums[k + 1]) {
	                     k--;
	                 }
	             } else if(nums[j] + nums[k] > target) {
	                 k--;
	             } else {
	                 j++;
	             }
	         }
	     }
	     
	     return result;
	 }

}
