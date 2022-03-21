package udemy;

import dataStructures.LinkedList;
import dataStructures.LinkedList.Node;

// Two pointers, fast and slow. fast = slow+k

public class RemoveKthNodeFromLL {

	public class ListNode {
		public int val;
		public ListNode next;
		public ListNode(int x) { val = x; }
	}

  public static void main(String[] args) {
	  LinkedList ll = new LinkedList();
	  ll.push(1);
	  ll.push(2);
	  ll.push(3);
	  ll.push(4);
	  ll.push(5);
	  ll.push(6);
	  ll.push(7);
	  ll.push(8);
	  ll.printLL();
	  
	  removeKthNodeFromEndOfLL(ll, 8);
	  
	  ll.printLL();
  }
  
  public static void removeKthNodeFromEndOfLL(LinkedList list, int k) {
	  Node fast = list.head;
	  Node slow = list.head;
	  
	  while (k > 0) {
		  fast = fast.next;
		  k--;
	  }
	  
	  while (fast.next != null) {
		  fast = fast.next;
		  slow = slow.next;
	  }
	  
	  slow.next = slow.next.next;
	  
  }
  
  public ListNode removeNthFromEnd(ListNode head, int n) {
	    ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    ListNode first = dummy;
	    ListNode second = dummy;
	    // Advances first pointer so that the gap between first and second is n nodes apart
	    for (int i = 1; i <= n + 1; i++) {
	        first = first.next;
	    }
	    // Move first to the end, maintaining the gap
	    while (first != null) {
	        first = first.next;
	        second = second.next;
	    }
	    second.next = second.next.next;
	    return dummy.next;
	}
}
