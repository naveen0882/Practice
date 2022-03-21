package udemy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class KeyPhrasesInSentence {

  public static void main(String[] args) {
	  String text = "The project, a feature on slavery in the U.S. that aims to shift perceptions of American history and change what students are taught in schools, won the 2020 Pulitizer Prize for Commentary. However, after receiving scrutiny from historians and politicians, the Times issued a clarification on the project.";
	  
	  System.out.println(getKeyPhrase(text));
  }
  
  static String getKeyPhrase(String text) {
	  Map<String, Integer> map = new HashMap<>();
	  ArrayList<String> dict = new ArrayList<>();
	  dict.add("a");
	  dict.add("on");
	  dict.add("in");
	  dict.add("the");
	  dict.add("to");
	  dict.add("that");
	  dict.add("and");
	  dict.add("are");
	  dict.add("what");
	  dict.add("for");
	  
	  String[] charArry = text.split(" ");
	  int maxFreq = 0;
	  for (String word : charArry) {
		  String key = word.trim().toLowerCase();
		  
		  if (dict.contains(key)) {
			  continue;
		  }
		  if (map.containsKey(key)) {
			  map.put(key, map.get(key)+1);
		  } else {
			  map.put(key, 1);
		  }	 
		  
		  if (map.get(key) > maxFreq) {
			  maxFreq = map.get(key);
		  }
	  }
	  
	  for (String key : map.keySet()) {
		  if (map.get(key) == maxFreq) {
			  System.out.println(key+" : "+map.get(key));
		  }
	  }
	  
	  return null;
  }

}
