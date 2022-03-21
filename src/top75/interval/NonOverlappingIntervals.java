package interval;

import java.util.*;

/*
Given an array of intervals intervals where intervals[i] = [starti, endi], 
return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Example 1:

Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.

Example 2:

Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.

Example 3:

Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
*/

public class NonOverlappingIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int eraseOverlapIntervals1(int[][] intervals) {
        if(intervals == null)   return 0;
        int count = 0;
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[1],b[1]));
        int prev_End = intervals[0][1];
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] < prev_End)  
            	count++;
            else    
            	prev_End = intervals[i][1];
        }
        return count;
    }
    
     class myComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.end - b.end;
        }
    }
    
    
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Interval [] arr=new Interval[intervals.length];
        
        for(int i =0;i<arr.length;i++){
            arr[i]=new Interval(intervals[i][0],intervals[i][1]);
            
        }
         Arrays.sort(arr, new myComparator());
        
        
//         we are by default including the first activity
        
        ArrayList<ArrayList<Integer>> list =new ArrayList<>();
        
        ArrayList<Integer> list2=new ArrayList<>();
                list2.add(arr[0].start);
                list2.add(arr[0].end);
        list.add(list2);
        
        int prev=0; 
        
        for(int curr =0;curr<arr.length;curr++){
          
            if(arr[curr].start>=arr[prev].end){
                ArrayList<Integer> list1=new ArrayList<>();
                list1.add(arr[curr].start);
                list1.add(arr[curr].end);
                list.add(list1);
                prev=curr;
            }
            
        }
        
        
        System.out.println(list);
        
        return arr.length-list.size();

    }

}
