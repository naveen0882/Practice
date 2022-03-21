package linkedlist;

/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:

Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:

Input: head = [1], n = 1
Output: []

Example 3:

Input: head = [1,2], n = 1
Output: [1]
*/
public class RemoveNthNodeFromList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first=head;
        if(head==null)
            return head;
        for(int i=1;i<=n;i++)
            first=first.next;
        ListNode second=head,prevSec=null;
        while(first!=null){
            first=first.next;
            prevSec=second;
            second=second.next;
        }
        if(second==head){
            ListNode temp=second;
            head=head.next;
            temp=null;
        }
       else if(second.next==null)
            prevSec.next=null;
        else {
            prevSec.next=second.next;
        }
        return head;
    }

}
