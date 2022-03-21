package interval;

import java.util.*;

/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] 
find the minimum number of conference rooms required.
*/
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class MeetingRooms2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int minMeetingRooms(int[][] intervals) {
	    Arrays.sort(intervals, Comparator.comparing((int[] itv) -> itv[0]));
	 
	    PriorityQueue<Integer> heap = new PriorityQueue<>();
	    int count = 0;
	    for (int[] itv : intervals) {
	        if (heap.isEmpty()) {
	            count++;
	            heap.offer(itv[1]);
	        } else {
	            if (itv[0] >= heap.peek()) {
	                heap.poll();
	            } else {
	                count++;
	            }
	 
	            heap.offer(itv[1]);
	        }
	    }
	 
	    return count;
	}
	
	class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start;
        }
    }
    
	public int minMeetingRooms(Interval[] intervals) {
        PriorityQueue<Integer> end = new PriorityQueue<Integer>();
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new IntervalComparator());
        end.add(intervals[0].end);
        for (int i = 1; i < intervals.length; i ++) {
            if (intervals[i].start >= end.peek()) {
                end.poll();
            }
            end.add(intervals[i].end);
        }
        return end.size();
    }

}
