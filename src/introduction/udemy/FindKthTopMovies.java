package udemy;

import java.util.Collections;
import java.util.PriorityQueue;

// Top movies in a stream

public class FindKthTopMovies {

  public static void main(String[] args) {
	  int[] streamRatings = {2,4,5,6,6,8,4,7,9};
	  int k = 3;
	  
	  PriorityQueue<Integer> pq = new PriorityQueue<>();
	  PriorityQueue<Integer> pq2 = new PriorityQueue<>(4, Collections.reverseOrder());
	  
	  for (int i=0; i<streamRatings.length; i++) {
		  pq.add(streamRatings[i]);
		  if(pq.size() > k) {
			  pq.poll();
		  }
	  }
	  
	  System.out.print(pq);  
  }

}
