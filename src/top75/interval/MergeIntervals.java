package interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, 
and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

*/	
public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public List<Interval> merge(List<Interval> intervals) {
	        List<Interval> result = new ArrayList<Interval>();
	        if(intervals == null || intervals.size() == 0) {
	            return result;
	        }
	        
	        Interval[] allIntervals = intervals.toArray(new Interval[intervals.size()]);
	        Arrays.sort(allIntervals, new Comparator<Interval>() {
	           public int compare(Interval a, Interval b) {
	               if(a.start == b.start) {
	                   return a.end - b.end;
	               }
	               return a.start - b.start;
	           } 
	        });
	        
	        for(Interval i: allIntervals) {
	            if (result.size() == 0 || result.get(result.size() - 1).end < i.start) {
	                    result.add(i);
	            } else {
	                result.get(result.size() - 1).end = Math.max(result.get(result.size() - 1).end, i.end);
	            }
	        }
	        
	        return result;
	 }

}
