package dataStructures;

// Add, Delete, Traverse

public class Stack {
	
	StackNode root;
	
	public static class StackNode {
		public int data;
		public StackNode next;
		
		public StackNode(int data) {
			this.data = data;
			next = null;
		}		
	}
	
	public boolean isEmpty() {
		if (root == null)
			return true;
		
		return false;
	}
	
	public void push(int data) {
		StackNode newStackNode = new StackNode(data);
		
		newStackNode.next = root;
		root = newStackNode;		
	}

	public int pop() {
		int response = 0;
		
		if (root == null) {
			System.out.println("Stack is Empty");
		} else {
			response = root.data;
			root = root.next;
		}

		return response;
	}

	public int peek() {
		int response = 0;
		
		if (root == null) {
			System.out.println("Stack is Empty");
		} else {
			response = root.data;
		}

		return response;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack sll = new Stack(); 
		  
        sll.push(10); 
        sll.push(20); 
        sll.push(30); 
  
        System.out.println(sll.pop() + " popped from stack"); 
  
        System.out.println("Top element is " + sll.peek()); 
	}

}
