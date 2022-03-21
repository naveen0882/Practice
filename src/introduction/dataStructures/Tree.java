package dataStructures;

import java.util.*;
import java.util.Queue;
import java.util.LinkedList;

//DFS, BFS, Adjacency Matrix

public class Tree {
	
	private Queue<Node> queue;
	static ArrayList<Node> nodes=new ArrayList<Node>();
	static class Node
	{
		int data;
		boolean visited;
		List<Node> neighbours;
 
		Node(int data)
		{
			this.data=data;
			this.neighbours=new ArrayList<>();
 
		}
		public void addneighbours(Node neighbourNode)
		{
			this.neighbours.add(neighbourNode);
		}
		public List<Node> getNeighbours() {
			return neighbours;
		}
		public void setNeighbours(List<Node> neighbours) {
			this.neighbours = neighbours;
		}
	}
 
	public Tree()
	{
		queue = new LinkedList<Node>();
	}
 
	public void bfs(Node node)
	{
		queue.add(node);
		node.visited=true;
		while (!queue.isEmpty())
		{
 
			Node element=queue.remove();
			System.out.print(element.data + "");
			List<Node> neighbours=element.getNeighbours();
			for (int i = 0; i < neighbours.size(); i++) {
				Node n=neighbours.get(i);
				if(n!=null && !n.visited)
				{
					queue.add(n);
					n.visited=true;
 
				}
			}
 
		}
	}
	
	/////////////////////
	
	private Queue<Node2> queue2;
	static ArrayList<Node2> nodes2=new ArrayList<Node2>();
	static class Node2
	{
		int data;
		boolean visited;
 
		Node2(int data)
		{
			this.data=data;
 
		}
	}
 
	public Tree(int x)
	{
		queue2 = new LinkedList<Node2>();
	}
 
	// find neighbors of node using adjacency matrix
	// if adjacency_matrix[i][j]==1, then nodes at index i and index j are connected
	public ArrayList<Node2> findNeighbours(int adjacency_matrix[][],Node2 x)
	{
		int nodeIndex=-1;
 
		ArrayList<Node2> neighbours=new ArrayList<Node2>();
		for (int i = 0; i < nodes2.size(); i++) {
			if(nodes2.get(i).equals(x))
			{
				nodeIndex=i;
				break;
			}
		}
 
		if(nodeIndex!=-1)
		{
			for (int j = 0; j < adjacency_matrix[nodeIndex].length; j++) {
				if(adjacency_matrix[nodeIndex][j]==1)
				{
					neighbours.add(nodes2.get(j));
				}
			}
		}
		return neighbours;
	}
 
	public void bfs(int adjacency_matrix[][], Node2 node)
	{
		queue2.add(node);
		node.visited=true;
		while (!queue2.isEmpty())
		{
 
			Node2 element=queue2.remove();
			System.out.print(element.data + " ");
			ArrayList<Node2> neighbours=findNeighbours(adjacency_matrix,element);
			for (int i = 0; i < neighbours.size(); i++) {
				Node2 n=neighbours.get(i);
				if(n!=null && !n.visited)
				{
					queue2.add(n);
					n.visited=true;
 
				}
			}
 
		}
	}

	public static void main(String[] args) {
		Node node40 =new Node(40);
		Node node10 =new Node(10);
		Node node20 =new Node(20);
		Node node30 =new Node(30);
		Node node60 =new Node(60);
		Node node50 =new Node(50);
		Node node70 =new Node(70);
 
		node40.addneighbours(node10);
		node40.addneighbours(node20);
		node10.addneighbours(node30);
		node20.addneighbours(node10);
		node20.addneighbours(node30);
		node20.addneighbours(node60);
		node20.addneighbours(node50);
		node30.addneighbours(node60);
		node60.addneighbours(node70);
		node50.addneighbours(node70);
		System.out.println("The BFS traversal of the graph is ");
		Tree bfsExample = new Tree();
		bfsExample.bfs(node40);
		
		//////////////////
		
		Node2 node401 =new Node2(40);
		Node2 node101 =new Node2(10);
		Node2 node201 =new Node2(20);
		Node2 node301 =new Node2(30);
		Node2 node601 =new Node2(60);
		Node2 node501 =new Node2(50);
		Node2 node701 =new Node2(70);
 
		nodes2.add(node401);
		nodes2.add(node101);
		nodes2.add(node201);
		nodes2.add(node301);
		nodes2.add(node601);
		nodes2.add(node501);
		nodes2.add(node701);
		int adjacency_matrix[][] = {
				{0,1,1,0,0,0,0}, // Node 1: 40
				{0,0,0,1,0,0,0}, // Node 2 :10
				{0,1,0,1,1,1,0}, // Node 3: 20
				{0,0,0,0,1,0,0}, // Node 4: 30
				{0,0,0,0,0,0,1}, // Node 5: 60
				{0,0,0,0,0,0,1}, // Node 6: 50
				{0,0,0,0,0,0,0}, // Node 7: 70
		};
		System.out.println("The BFS traversal of the graph is ");
		Tree bfsExample2 = new Tree(1);
		bfsExample2.bfs(adjacency_matrix, node401);
 

	}

}
