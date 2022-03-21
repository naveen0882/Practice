package udemy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ParenthesesExpression {

  public static void main(String[] args) {
	  
	  String expression = "([{[]}])";
	  
	  Map<Character, Character> pairs = new HashMap<Character, Character>();
	  pairs.put('(', ')');
	  pairs.put('{', '}');
	  pairs.put('[', ']');
	  
	  Stack<Character> stack = new Stack<>();
	  
	  for(int i=0; i<expression.length(); i++) {
		  if (pairs.containsKey(expression.charAt(i))) {
			  stack.push(expression.charAt(i));
		  } else if (expression.charAt(i) == ')' || expression.charAt(i) == '}' || expression.charAt(i) == ']') {
			  if(stack.isEmpty()) {
				  System.out.println("Invalid expression");
			  } else if (pairs.get(stack.pop()) != expression.charAt(i)) {
				  System.out.println("Invalid expression");
			  }
			  
		  }		  
	  }
	  
	  System.out.println("Valid expression");
	  
  }

}
