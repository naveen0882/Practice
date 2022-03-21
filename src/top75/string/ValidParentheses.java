package string;

import java.util.Stack;

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 
Example 1:

Input: s = "()"
Output: true

Example 2:

Input: s = "()[]{}"
Output: true

Example 3:

Input: s = "(]"
Output: false

 */
public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isValid(String s) {
        if(s.length() % 2 == 1) {
            return false;
        }
        
        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else if(s.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == ')') {
                stack.pop();
            } else if(s.charAt(i) == ']' && !stack.isEmpty() && stack.peek() == ']') {
                stack.pop();
            } else if(s.charAt(i) == '}' && !stack.isEmpty() && stack.peek() == '}') {
                stack.pop();
            } else {
                return false;
            }
        }
        
        return stack.isEmpty();
    }

}
