package udemy;

import java.util.ArrayList;
import java.util.List;

// Find longest sequence of 1s with one flip
// 1 , 1 , 0, 1, 1, 1, 1, 0, 1, 1 --> 7
// 2, 0, 4, 0, 2

public class ArrayWithManyZeros {

  public static void main(String[] args) {
	  int[] input = {1,1,0,1,1,1,1,0,1,1};
	  System.out.println(getLongestSequence(input));
	  
	  int[] input2 = {1,1,0,1,0,1,1,0,1,1,0};
	  System.out.println(getLongestSequence(input2));

  }
  
  private static int getLongestSequence(int[] input) {
	  int seqTotal = 0;	  
	  List<Integer> list = new ArrayList<>();
	  for (int i=0; i<input.length; i++) {
		  if (input[i] == 1) {
			  seqTotal++;
			  if (i == input.length-1) {
				  list.add(seqTotal);
			  }
		  } else {
			  list.add(seqTotal);
			  seqTotal = 0;
			  list.add(0);
		  }
	  }
	  
	  System.out.println(list.toString());
	  
	  int max = 0;
	  for (int i=0; i<list.size(); i=i+2) {
		  int len = list.get(i);
		  if (i+1 < list.size()) {
			  len = len+1;
		  }
		  if (i+2 < list.size()) {
			  len = len+list.get(i+2);
		  }
		  if (len > max) {
			  max = len;
		  }
	  
	  }
	  
	  return max;
	  
  }

}
