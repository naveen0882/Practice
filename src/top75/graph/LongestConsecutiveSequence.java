package graph;

import java.util.HashSet;
import java.util.Set;

/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 
 */
public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        Set<Integer> set = new HashSet<Integer>();
        for(int n: nums) {
            set.add(n);
        }
        
        int maxLength = 0;
        for(int n: set) {
            if(!set.contains(n - 1)) {
                int current = n;
                int currentMax = 1;
                
                while(set.contains(n + 1)) {
                    currentMax++;
                    n++;
                }
                
                maxLength = Math.max(maxLength, currentMax);
            }
        }
        
        return maxLength;
    }
	
	public int longestConsecutive2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int result = 0;
        for(int i=0;i<nums.length;i++){
            int val = nums[i];
            //check for val-1, if found which confirm curr val is not the begining of consecutive numbers series, it will start with smaller value which is available in the array at later stage
            if(set.contains(val-1)){
                continue;
            }
            //look for curr value
            if(set.contains(val)){
                int cons = 0;
				//increase the val by 1 everytime and check whether set contains that too and whenever it does not contain next val then that is range of consecutive numbers
                while(set.contains(val)){
                    val = val + 1;
                    cons++;
                }
                result = Math.max(result, cons);
            }
            
        }
        return result;
    }

}
