package dataStructures;

//Add, Delete, Traverse

public class Queue {
	
	QueueNode head;
	QueueNode tail;
	
	public static class QueueNode {
		public int data;
		public QueueNode next;
		
		public QueueNode(int data) {
			this.data = data;
			next = null;
		}		
	}
	
	public void enqueue(int data) {
		QueueNode newQueueNode = new QueueNode(data);
		
		if (head == null) {
			head = newQueueNode;
			tail = newQueueNode;
			return;
		}
		
		tail.next = newQueueNode;
		tail = newQueueNode;
	}
	
	public int dequeue() {
		
		if (head == null)
			System.out.println("Queue is Empty");
		
		QueueNode temp = head;
		this.head = this.head.next; 
		
		if (this.head == null) 
            this.tail = null; 
				
		return temp.data;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue q = new Queue(); 
        q.enqueue(10); 
        q.enqueue(20); 
        q.dequeue(); 
        q.dequeue(); 
        q.enqueue(30); 
        q.enqueue(40); 
        q.enqueue(50); 
  
        System.out.println("Dequeued item is " + q.dequeue());
	}

}
