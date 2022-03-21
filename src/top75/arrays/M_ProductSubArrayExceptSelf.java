package arrays;

import java.util.Arrays;

/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 
 */
public class M_ProductSubArrayExceptSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {-1,1,0,-3,3};
		System.out.println(Arrays.toString(productExceptSelf(input)));
	}
	
	public static int[] productExceptSelf(int[] nums) {
        
        int length = nums.length;
        
        int ans[] = new int[length];
        
        ans[0] = 1;
        for(int i = 1; i < length; i++) {
            ans[i] = nums[i-1] * ans[i-1];
        }
        
        int R = 1;
        for(int i=length-1; i>=0; i--) {
            ans[i] *= R;
            R *= nums[i];
        }
        
        return ans;
    }

}
