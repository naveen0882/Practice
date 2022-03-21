package arrays;

import java.util.Arrays;
import java.util.HashMap;

/* Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 * */
public class E_TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {2,7,11,15};
		System.out.println(Arrays.toString(getTwoSum(input, 9)));

	}
	
	public static int[] getTwoSum(int[] input, int target) {
		int[] result = new int[2];
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int i=0; i<input.length; i++) {
			if (map.containsKey(target-input[i])) {
				result[0] = map.get(target-input[i]);
				result[1] = i;
				return result;
			} 
			
			map.put(input[i], i);
			
		}
		
		return result;
	}

}
