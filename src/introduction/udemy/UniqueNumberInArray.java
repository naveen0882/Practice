package udemy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UniqueNumberInArray {

  public static void main(String[] args) {
	  int[] array = {1,3,5,5,6,6,7,8,10,10};
	  ArrayList<Integer> uniqueNumbers = getUniqueNumbers(array);
	  
	  for (Integer num: uniqueNumbers) {
		  System.out.println(num);
	  }	  
  }
  
  static ArrayList<Integer> getUniqueNumbers(int[] array) {
	  Map<Integer, Integer> map = new HashMap<>();
	  ArrayList<Integer> response = new ArrayList<>();
	  
	  for (int i=0; i<array.length; i++) {
		  if (map.containsKey(array[i])) {
			  map.put(array[i], map.get(array[i])+1);
		  } else {
			  map.put(array[i], 1);
		  }
	  }	
	  
	  for (int key : map.keySet()) {
		  if (map.get(key) == 1) {
			  response.add(key);
		  }
	  }
	  
	  return response;
	  
  }

}
