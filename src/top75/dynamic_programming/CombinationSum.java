package dynamic_programming;

import java.util.*;

/*
Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.

The test cases are generated so that the answer can fit in a 32-bit integer.

Example 1:

Input: nums = [1,2,3], target = 4
Output: 7
Explanation:
The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
Note that different sequences are counted as different combinations.

Example 2:

Input: nums = [9], target = 3
Output: 0
 
Follow up: What if negative numbers are allowed in the given array? 
How does it change the problem? What limitation we need to add to the question to allow negative numbers?
*/
public class CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,2,3};
		System.out.println(combinationSum4(input, 4));
	}
	
	public static int combinationSum4(int[] nums, int target) {
        
        int[] dp = new int[target + 1];
        dp[0] = 1;
        
        for(int i = 1; i < dp.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                
                if(i - nums[j] >= 0) {
                    
                    dp[i] += dp[i - nums[j]];
                    
                }
                
            }
            
        }
        
        return dp[target];
        
    }
	
	List<List<Integer>> resultList = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] arr, int target) {           
        getTargetCombination(arr, 0, target, new ArrayList<Integer>());
        return resultList;
    }
    
    
    public void getTargetCombination(int[] arr, int position, int currentTarget, List<Integer> result) {

        /**
         * Base case
         * 1. If currentTarget is reaching to Zero
         * 2. Current Position is equal to the length of the Array
         */
        if (currentTarget == 0) {
            resultList.add(new ArrayList<>(result));
            return;
        }
        if (position == arr.length) {
            return;
        }

        /**
         * There are two cases
         * 1. Pick the current value if the current value (i.e arr[position]) is less than or equal to the currentTarget
         *    value then use the same attribute by passing the same position
         *
         *  2. Not picking up the current element by not reducing the currentTarget value and increasing the position
         */
        if (arr[position] <= currentTarget) {
            result.add(arr[position]);
            getTargetCombination(arr, position, currentTarget - arr[position], result);
            // removing the last element because post adding of the value the call came back
            result.remove(result.size() - 1);
        }
        // not picked
        getTargetCombination(arr, position + 1, currentTarget, result);
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		//sort array sot hat duplicate elements will be together
		Arrays.sort(candidates);
		combinationSum2(candidates, target, 0, ans, new ArrayList<>(), false);
		return ans;
	}

	private void combinationSum2(int[] arr, int target, int i, List<List<Integer>> ans, List<Integer> list,
			boolean flag) {
		if (target == 0) {
			ans.add(new ArrayList<>(list));
			return;
		}
		if (arr.length == i || target < 0) {
			return;
		}
		//call with false since we are ignoring ith element here
		combinationSum2(arr, target, i + 1, ans, list, false);
		//if flag false and element i and i-1 same, dont consider ith element
		if (!flag && i > 0 && arr[i] == arr[i - 1]) {
			return;
		}
		list.add(arr[i]);
		//since it is asked duplicate not allowed increment i
		//since we are considering ith element here call with true
		combinationSum2(arr, target - arr[i], i + 1, ans, list, true);
		list.remove(list.size() - 1);
	}

}
