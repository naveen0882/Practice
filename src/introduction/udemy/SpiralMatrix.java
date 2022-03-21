package udemy;

// Given 2d array, print spiral mqtrix

//   --> --> --> |
//               |
//               v
public class SpiralMatrix {

  public static void main(String[] args) {
	  int[][] input = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
	  printSpiralMatrix(input);
  }
  
  private static void printSpiralMatrix(int[][] input) {
	  int firstRow = 0;
	  int lastRow = input.length-1;
	  int firstCol = 0;
	  int lastCol = input[0].length-1;
	  
	  while (firstRow < lastRow && firstCol < lastCol) {
		  
		  for (int i = firstCol; i<= lastCol; i++) {
			  System.out.println(input[firstRow][i]);
		  }
		  
		  for (int i = firstRow+1; i<= lastRow; i++) {
			  System.out.println(input[i][lastCol]);
		  }
		  
		  for (int i = lastCol-1; i>= firstCol; i--) {
			  System.out.println(input[lastRow][i]);
		  }
		  
		  for (int i = lastRow-1; i> firstRow; i--) {
			  System.out.println(input[i][firstCol]);
		  }
		  
		  firstRow++;
		  lastRow--;
		  firstCol++;
		  lastCol--;
	  }
	  
  }

}
