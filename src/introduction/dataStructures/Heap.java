package dataStructures;
import java.util.*;
import java.util.Comparator;

public class Heap {
	PriorityQueue<?> minHeap = new PriorityQueue<>();
	PriorityQueue<?> maxHeap = new PriorityQueue<>(10, new MyComparator());
	
	public class MyComparator implements Comparator<Integer> {
        public int compare( Integer x, Integer y ){
            return y - x;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
