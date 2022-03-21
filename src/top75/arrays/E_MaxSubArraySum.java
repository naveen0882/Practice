package arrays;

import java.util.Arrays;

/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Example 2:

Input: nums = [1]
Output: 1

Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
 */

public class E_MaxSubArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSumOfSubArray(input));
	}
	
	public static int maxSumOfSubArray(int[] input) {
	        int[] dp = new int[input.length];
	        
	        dp[0] = input[0];
	        
	        int max = dp[0];
	        
	        for(int i = 1; i < input.length; i++) {
	            dp[i] = input[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
	            max = Math.max(dp[i], max);
	        }
	        
	        return max;

	}

}
