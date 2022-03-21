package arrays;

/*
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, 
nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) 
such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). 
For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:

Input: nums = [1], target = 0
Output: -1

 */
public class M_SearchRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int search(int[] nums, int target) {
        
        int low=0, high=nums.length-1;
        
        while(low<high) {
            int mid = low + (high-low)/2;
            
            if (nums[mid]==target) {
                return mid;
            } 
            //result is guaranteed to be in the right. Example: [3 4 5 1 2], 1
            else if (nums[mid]> nums[high] && nums[low]> target) {
                low = mid+1;
            }
            //result is guaranteed to be in the left. Example: [4 5 1 2 3], 5
            else if (nums[mid]< nums[low] && nums[high]< target) {
                high = mid;
            }
            else if (nums[mid]<target) {
                low = mid+1;
            }
            else {
                high = mid;
            }
        }
        
        return nums[low] == target ? low : -1;
	}
	
	public int search2(int[] arr, int target) {
	    int left=0,right=arr.length-1;
	        while(left<=right){
	            int mid=left+(right-left)/2;
	            if(target==arr[mid]) return mid;  // founded ;)
	            if(arr[left]<=arr[mid]){  // left increasing monotonically
	                if(arr[left]<=target && target<arr[mid]){  // inside this region
	                    right=mid-1;
	                }
	                else left=mid+1;
	            }else{                     // right increasing monotonically
	                if(arr[mid]<target && target<=arr[right]){  // inside this region
	                    left=mid+1;
	                }
	                else right=mid-1;
	            }
	        }
	        return -1;
	    }

}
