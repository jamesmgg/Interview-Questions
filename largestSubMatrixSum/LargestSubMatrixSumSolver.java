package largestSubMatrixSum;

public class LargestSubMatrixSumSolver {
	
	static int[][] findLargest(int[][] arr) {
		int[][] max = null;
		for (int col = 0; col < arr[0].length; col++) {
			for (int row = 0; row < arr.length; row++) {
				int[][] localMax = findLargestContainingIndex(arr, col, row);
				if (sum(localMax) > sum(max)) {
					max = localMax;
				}
			}
		}
		return max;
	}

	// Finds largest matrix from col->arr[0].length and row->arr.length.
	static int[][] findLargestContainingIndex(int[][] arr, int col, int row) {
		int[][] max = null;
		for (int i = col; i < arr[0].length; i++) {
			for (int j = row; j < arr.length; j++) {
				int[][] subMatrix = getSubMatrix(arr, i - col + 1, j - row + 1, col, row);
				if (sum(subMatrix) > sum(max)) {
					max = subMatrix;
				}
			}
		}
		return max;
	}

	static int[][] getSubMatrix(int[][] arr, int rowSize, int colSize, int col, int row) {
		int[][] subMatrix = new int[rowSize][colSize];
		for (int k = col; k < col + colSize && k < arr[0].length; k++) {
			for (int l = row; l < row + rowSize && l < arr.length; l++) {
				subMatrix[l - row][k - col] = arr[l][k];
			}
		}
		return subMatrix;
	}

	static int sum(int[][] arr) {
		int sum = 0;
		for (int i = 0; arr != null && arr.length > 0 && i < arr[0].length; i++) {
			for (int j = 0; j < arr.length; j++ ) {
				sum += arr[j][i];
			}
		}
		return sum;
	}
}
