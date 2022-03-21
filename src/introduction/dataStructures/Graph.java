package dataStructures;

import java.util.*;
import java.util.Stack;

// DFS, Adjacency Matrix

public class Graph {
	
	static class Node {
		int data;
		boolean visited;
		List<Node> neighbours;
 
		Node(int data) {
			this.data=data;
			this.neighbours=new ArrayList<>();
 
		}
		
		public void addneighbours(Node neighbourNode) {
			this.neighbours.add(neighbourNode);
		}
		
		public List<Node> getNeighbours() {
			return neighbours;
		}
		
		public void setNeighbours(List<Node> neighbours) {
			this.neighbours = neighbours;
		}
	}
	
	// Iterative DFS using stack
		public  void dfsUsingStack(Node node)
		{
			Stack<Node> stack=new  Stack<Node>();
			stack.add(node);
			node.visited=true;
			while (!stack.isEmpty())
			{
				Node element=stack.pop();
				System.out.print(element.data + " ");
	 
				List<Node> neighbours=element.getNeighbours();
				for (int i = 0; i < neighbours.size(); i++) {
					Node n=neighbours.get(i);
					if(n!=null && !n.visited)
					{
						stack.add(n);
						n.visited=true;
	 
					}
				}
			}
		}
		
		// Recursive DFS
		public  void dfs(Node node)
		{
			System.out.print(node.data + " ");
			List<Node> neighbours = node.getNeighbours();
	        node.visited=true;
			for (int i = 0; i < neighbours.size(); i++) {
				Node n = neighbours.get(i);
				if(n!=null && !n.visited)
				{
					dfs(n);
				}
			}
		}
		
		
	//////////////
		
		static ArrayList<AdjacencyNode> nodes=new ArrayList<>();
		static class AdjacencyNode {
			int data;
			boolean visited;
	 
			AdjacencyNode(int data) {
				this.data=data;
			}
		}
		
		
		// find neighbors of node using adjacency matrix
		// if adjacency_matrix[i][j]==1, then nodes at index i and index j are connected
		public ArrayList<AdjacencyNode> findNeighbours(int adjacency_matrix[][], AdjacencyNode x)
		{
			int nodeIndex=-1;
	 
			ArrayList<AdjacencyNode> neighbours=new ArrayList<>();
			for (int i = 0; i < nodes.size(); i++) {
				if(nodes.get(i).equals(x))
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
						neighbours.add(nodes.get(j));
					}
				}
			}
			return neighbours;
		}
	 
	 
		// Recursive DFS
		public  void dfs(int adjacency_matrix[][], AdjacencyNode node)
		{
	 
			System.out.print(node.data + " ");
			ArrayList<AdjacencyNode> neighbours = findNeighbours(adjacency_matrix,node);
	        node.visited=true;
			for (int i = 0; i < neighbours.size(); i++) {
				AdjacencyNode n = neighbours.get(i);
				if(n!=null && !n.visited)
				{
					dfs(adjacency_matrix,n);
				}
			}
		}
	 
		// Iterative DFS using stack
		public  void dfsUsingStack(int adjacency_matrix[][], AdjacencyNode node)
		{
			Stack<AdjacencyNode> stack=new  Stack<>();
			stack.add(node);
			node.visited=true;
			while (!stack.isEmpty())
			{
				AdjacencyNode element=stack.pop();
				System.out.print(element.data + " ");
	 
				ArrayList<AdjacencyNode> neighbours=findNeighbours(adjacency_matrix,element);
				for (int i = 0; i < neighbours.size(); i++) {
					AdjacencyNode n=neighbours.get(i);
					if(n!=null &&!n.visited)
					{
						stack.add(n);
						n.visited=true;
	 
					}
				}
			}
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
 
		Graph dfsExample = new Graph();
 
		System.out.println("The DFS traversal of the graph using stack ");
		dfsExample.dfsUsingStack(node40);
 
		System.out.println();
 
		// Resetting the visited flag for nodes
		node40.visited=false;
		node10.visited=false;
		node20.visited=false;
		node30.visited=false;
		node60.visited=false;
		node50.visited=false;
		node70.visited=false;
 
 
		System.out.println("The DFS traversal of the graph using recursion ");
		dfsExample.dfs(node40);
		
		//////////////////
		
		AdjacencyNode node401 =new AdjacencyNode(40);
		AdjacencyNode node101 =new AdjacencyNode(10);
		AdjacencyNode node201 =new AdjacencyNode(20);
		AdjacencyNode node301 =new AdjacencyNode(30);
		AdjacencyNode node601 =new AdjacencyNode(60);
		AdjacencyNode node501 =new AdjacencyNode(50);
		AdjacencyNode node701 =new AdjacencyNode(70);
 
		nodes.add(node401);
		nodes.add(node101);
		nodes.add(node201);
		nodes.add(node301);
		nodes.add(node601);
		nodes.add(node501);
		nodes.add(node701);
		int adjacency_matrix[][] = {
				{0,1,1,0,0,0,0},  // Node 1: 40
				{0,0,0,1,0,0,0},  // Node 2 :10
				{0,1,0,1,1,1,0},  // Node 3: 20
				{0,0,0,0,1,0,0},  // Node 4: 30
				{0,0,0,0,0,0,1},  // Node 5: 60
				{0,0,0,0,0,0,1},  // Node 6: 50
				{0,0,0,0,0,0,0},  // Node 7: 70
		};
 
		Graph dfsExampleAdjacency = new Graph();
 
		System.out.println("The DFS traversal of the graph using stack ");
		dfsExampleAdjacency.dfsUsingStack(adjacency_matrix, node401);
 
		System.out.println();
 
		clearVisitedFlags();
 
		System.out.println("The DFS traversal of the graph using recursion ");
		dfsExample.dfs(adjacency_matrix, node401);		
	}
	
	public static void clearVisitedFlags()
	{
		for (int i = 0; i < nodes.size(); i++) {
			nodes.get(i).visited=false;
		}
	}
}
