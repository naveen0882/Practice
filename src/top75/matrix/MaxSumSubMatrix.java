package matrix;

public class MaxSumSubMatrix {
	
		public static SubMatrix getMaxMatrix(int[][] matrix) {
			int rowCount = matrix.length;
			int colCount = matrix[0].length;
		
			SubMatrix best = null;
		
			for (int rowStart = 0; rowStart < rowCount; rowStart++) {
				int[] partialSum = new int[colCount];
			
				for (int rowEnd = rowStart; rowEnd < rowCount; rowEnd++) {
					/* Add values at row rowEnd. */
					for (int i = 0; i < colCount; i++) {
						partialSum[i] += matrix[rowEnd][i];
					}
			
					Range bestRange = maxSubArray(partialSum, colCount);
					if (best == null || best.getSum() < bestRange.sum) {
						best = new SubMatrix(rowStart, bestRange.start, rowEnd, bestRange.end, bestRange.sum);
					}
				}
			}
			return best;
		}

		public static Range maxSubArray(int[] array, int N) {
			Range best = null;
			int start = 0;
			int sum = 0;

			for (int i = 0; i < N; i++) {
				sum += array[i];
				if (best == null || sum > best.sum) {
					best = new Range(start, i, sum);
				}
				
				/* If running_sum is < 0 no point in trying to continue the 
				 * series. Reset. */
				if (sum < 0) {
					start = i + 1;
					sum = 0;
				}
			}
			return best;
		}
		
		public static void main(String[] args) {
			int[][] matrix = randomMatrix(10, 10, -5, 5);
			printMatrix(matrix);
			System.out.println(getMaxMatrix(matrix));
		}
		
		public static void printMatrix(int[][] matrix) {
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					if (matrix[i][j] < 10 && matrix[i][j] > -10) {
						System.out.print(" ");
					}
					if (matrix[i][j] < 100 && matrix[i][j] > -100) {
						System.out.print(" ");
					}
					if (matrix[i][j] >= 0) {
						System.out.print(" ");
					}
					System.out.print(" " + matrix[i][j]);
				}
				System.out.println();
			}
		}
		
		public static int[][] randomMatrix(int M, int N, int min, int max) {
			int[][] matrix = new int[M][N];
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					matrix[i][j] = randomIntInRange(min, max);
				}
			}
			return matrix;
		}
		
		public static int randomIntInRange(int min, int max) {
			return randomInt(max + 1 - min) + min;
		}
		
		public static int randomInt(int n) {
			return (int) (Math.random() * n);
		}

}

class SubMatrix {
	private int row1, row2, col1, col2, sum;
	public SubMatrix(int r1, int c1, int r2, int c2, int sm) {
		row1 = r1;
		col1 = c1;
		row2 = r2;
		col2 = c2;
		sum = sm;
	}
	
	public int getSum() {
		return sum;
	}
	
	@Override
	public String toString() {
		return "[(" + row1 + "," + col1 + ") -> (" + row2 + "," + col2 + ") = " + sum + "]";
	}
}

class Range {
	public int start, end, sum;
	public Range(int start, int end, int sum) {
		this.start = start;
		this.end = end;
		this.sum = sum;
	}

}
