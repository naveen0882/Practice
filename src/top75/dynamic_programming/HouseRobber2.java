package dynamic_programming;

/*
You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed. 
All houses at this place are arranged in a circle. 
That means the first house is the neighbor of the last one. 
Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police 
if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, 
return the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.

Example 2:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 3:

Input: nums = [1,2,3]
Output: 3
*/
public class HouseRobber2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length < 2) {
            return nums[0];
        }
        
        int[] first = new int[nums.length + 1];
        int[] second = new int[nums.length + 1];
        
        first[0]  = 0;
        first[1]  = nums[0];
        second[0] = 0;
        second[1] = 0;
        
        for (int i = 2; i <= nums.length; i++) {
            first[i] = Math.max(first[i - 1], first[i - 2] + nums[i - 1]);
            second[i] = Math.max(second[i - 1], second[i - 2] + nums[i - 1]);
        }
        
        return Math.max(first[nums.length - 1], second[nums.length]);
    }
	
	public int rob2(int[] nums) {
        
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return Math.max(nums[0],nums[1]);
        if(nums.length == 3)
            return Math.max(Math.max(nums[0],nums[1]),Math.max(nums[1],nums[2]));
       
        int x = robLogic(nums,0,nums.length-2);
        int y = robLogic(nums,1,nums.length-1);
        return Math.max(x,y);
    }
    
    private int robLogic(int[] nums, int st, int end){
        int even = 0,odd = 0;
        
        for(int i = st;i<=end;i++){
            if(i % 2 == 0){
                even = even + nums[i];
                even = Math.max(even,odd);
            }else{
                 odd = odd + nums[i];
                 odd = Math.max(even,odd);
            }
        }
        return Math.max(even,odd);
    }

}
