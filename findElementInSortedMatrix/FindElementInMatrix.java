package findElementInSortedMatrix;

public class FindElementInMatrix {

	static boolean findElement(int[][] arr, int num) {
		return findElementHelper(arr, num, arr[0].length - 1, 0);
	}

	//Recursive naive solution.
	private static boolean findElementHelper(int[][] arr, int num, int col, int row) {
		if (row >= arr.length || col < 0) {
			return false;
		}
		else if (arr[row][col] == num) {
			return true;
		}
		else {
			return findElementHelper(arr, num, col - 1, row) ||
					findElementHelper(arr, num, col, row + 1);
		}
	}
	
	static boolean findElementIterative(int[][] arr, int num) {
		int col = arr[0].length - 1;
		int row = 0;
		while (col >= 0 && row < arr.length) {
			if (arr[row][col] == num) {
				return true;
			}
			else if (arr[row][col] > num) {
				col--;
			}
			else {
				row ++;
			}
		}
		return false;
	}

}
