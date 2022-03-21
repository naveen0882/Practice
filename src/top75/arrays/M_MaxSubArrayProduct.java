package arrays;

import java.util.Arrays;

/*
Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

A subarray is a contiguous subsequence of the array.

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 
 */

public class M_MaxSubArrayProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {2,3,-2,4};
		System.out.println(maxSumOfSubArray(input));
	}
	
	public static int maxSumOfSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int result = nums[0];
        int max = nums[0];
        int min = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            int temp = max;

            max = Math.max(Math.max(nums[i] * max, nums[i] * min), nums[i]);
            min = Math.min(Math.min(nums[i] * temp, nums[i] * min), nums[i]);
            
            if(max > result) {
                result = max;
            }
        }
        
        return result;
    }
	
}
