package interval;

import java.util.List;

/*
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end 
of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] 
that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals 
still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
*/


	//Definition for an interval.
    class Interval {
    	int start;
    	int end;
    	Interval() { start = 0; end = 0; }
    	Interval(int s, int e) { start = s; end = e; }
    }


public class InsertInterval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int i = 0;

        while(i < intervals.size() && intervals.get(i).end < newInterval.start) {
            i++;
        }

        while(i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start), Math.max(intervals.get(i).end, newInterval.end));
            intervals.remove(i);
        }
        
        intervals.add(i, newInterval);

        return intervals;
    }

}
