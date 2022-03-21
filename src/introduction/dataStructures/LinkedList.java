package dataStructures;

// Add, Delete, Print, Search, Find length, Rotate, LL Sum

public class LinkedList {
	
	public Node head;
	
	public static class Node {
		public int data;
		public Node next;
		
		public Node(int data) {
			this.data = data;
			next = null;
		}
	}
	
	public void printLL() {
		Node n = this.head;
		
		while (n != null) {
			System.out.println(n.data);
			n = n.next;
		}
	}
	
	// Inserts at Head of LL
	public void push (int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}
	
	// Inserts After given Node
	public void insertAfter(Node previous, int data) {
		if (previous == null) {
			return;
		}

		Node newNode = new Node(data);
		newNode.next = previous.next;
		previous.next = newNode;		
	}
	
	public void append(int data) {
		Node newNode = new Node(data);
		if (this.head == null) {
			head = newNode;
			return;
		}
		
		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		
		current.next = newNode;
	}
	
	public void deleteNode(int data) {
		Node current = head;
		Node prev = null;
		
		if (current != null && current.data == data) {
			head = head.next;
			return;			
		}
		
		while (current.next != null && current.data != data) {
			prev = current;
			current = current.next;
		}
		
		if (current != null) 
			prev.next = current.next;		
	}
	
	public Node addTwoNode(Node one, Node two) {
		if (one == null || two == null)
			return null;
		
		Node result = null;
		Node temp = null;
		Node prev =  null;
		int carry = 0, sum;
		
		while (one != null || two != null) {
			sum = carry + (one != null? one.data : 0) +(two != null? two.data : 0);
			carry = sum >= 10 ? 1 : 0;
			sum = sum % 10;
			temp = new Node(sum);
			
			if (result == null) {
				result = temp;
			} else {
				prev.next = temp; 
			}
			
			prev = temp;
			
			if (one != null) {
				one = one.next;
			}
			
			if (two != null) {
				two = two.next;
			}
		}
		
		if (carry > 0)
			temp.next = new Node(carry);
		
		return result;	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList ll = new LinkedList();
		
		Node one = new Node(1);
		Node two = new Node(2);
		Node the = new Node(4);
		Node fix = new Node(7);
		
		ll.head = one;
		ll.head.next = two;
		ll.head.next.next = the;
		ll.head.next.next.next = fix;
		
		ll.printLL();
		
		ll.insertAfter(two, 3);
		ll.printLL();
		
		ll.append(8);
		ll.printLL();

	}

}
