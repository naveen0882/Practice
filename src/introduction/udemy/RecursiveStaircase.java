package udemy;

import java.util.ArrayList;
import java.util.Stack;

// Use stack
//stairs  1 ,2 3, 4 --> 2,4   2,3,4  1,3,4  1,2,4  1,2,3,4

public class RecursiveStaircase {
	
	class Stairs {
		int number;
		ArrayList<Integer> visited = new ArrayList<>();
		public Stairs(int number, ArrayList<Integer> visited) {
			this.number = number;
			this.visited.addAll(visited);
			this.visited.add(number);
		}
	}

	public static void main(String[] args) {
		new RecursiveStaircase().test();			
	}
	
	public void test() {
		int steps = 4;
		Stack<Stairs> stairStack = new Stack<>();
		stairStack.add(new Stairs(0, new ArrayList<Integer>()));
		
		while (!stairStack.isEmpty()) {
			Stairs currentStair = stairStack.pop();
			if (currentStair.number == steps) {
				System.out.println(currentStair.visited);
				continue;
			}
			
			int oneStair = currentStair.number+1;
			if (oneStair <= steps) {
				stairStack.add(new Stairs(oneStair, currentStair.visited));
			}
			
			int twoStair = currentStair.number+2;
			if (twoStair <= steps) {
				stairStack.add(new Stairs(twoStair, currentStair.visited));
			}
		}
	}

}
