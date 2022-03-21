package udemy;

import java.util.Stack;

// given list if words, [hot, dot, dog, lot, log, cog]
// Start --> hot -->dot -->lot --> log --> cog
// End --> cog

public class WordDistance {

  public static void main(String[] args) {
	  String[] dict = {"hot", "dot", "dog", "lot", "log", "cog"};
	  String start = "hit";
	  String end = "cog";
	  
	  System.out.println(findpath (dict, start, end));
  }
  
  static boolean findpath(String[] dic, String start, String end) {
	  boolean isFound = false;
	  boolean[] visited = new boolean[dic.length];
	  Stack<String> stack = new Stack<>();
	  stack.push(start);
	  
	  while(!stack.isEmpty()) {
		  String word = stack.pop();
		  
		  if(isLetterAway(word, end) == 0) {
			  stack.push(word);
			  System.out.println(stack);
			  isFound = true;
			  break;
		  }
		  
		  for(int i=0; i<dic.length; i++) {
			  if(visited[i])
				  continue;
			  
			  if(isLetterAway(word, dic[i]) == 1) {
				  visited[i] = true;
				  stack.push(word);
				  stack.push(dic[i]);
			  }
		  }
	  }
	  
	  return isFound;
  }
  
  static int isLetterAway(String word1, String word2) {
	  int len = 3;
	  
	  for(int i=0; i<word1.length(); i++) {
		  if (word1.charAt(i) == word2.charAt(i)) {
			  len--;
		  }	  
	  }
	  
	  return len;
  }

}
