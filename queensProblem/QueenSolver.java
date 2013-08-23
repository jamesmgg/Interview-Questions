package queensProblem;

public class QueenSolver {

	public static boolean[][] solveQueenPuzzle (boolean[][] board) {
		solveQueenPuzzle(board, 0, 0);
		return board;
	}
	
	private static boolean solveQueenPuzzle(boolean[][] board, int col, int numQueens) {
		for (int row = 0; row < board.length; row++) {
			board[row][col] = true;
			numQueens++;
			boolean isValid = isValid(board);
			if (isValid) {
				// Solution found.
				if (numQueens == 8) {
					return true;
				}
				else {
					if (solveQueenPuzzle(board, col + 1, numQueens)) {
						return true;
					}
				}
			}
			// Remove queen.
			board[row][col] = false;
			numQueens--;
		}
		return false;
	}
	private static boolean isValid (boolean[][] board) {
		for (int i = 0; i < board[0].length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[j][i] && intersectsQueen(board, i, j)) {
					return false;
				}
			}
		}
		// Reaching this point, board is valid.
		return true;
	}
	private static boolean intersectsQueen (boolean[][] board, int col, int row) {
		// If other queen on same row.
		for (int i = row + 1; i < board.length; i++) {
			if (board[i][col]) {
				return true;
			}
		}
		// If other queen on same column
		for (int j = col + 1; j < board[0].length; j++) {
			if (board[row][j]) {
				return true;
			}
		}
		// If other queen on bot, right diagonal.
		for (int i = row + 1, j = col + 1; i < board.length && j < board[0].length; i++, j++) {
			if (board[i][j]) {
				return true;
			}
		}
		// If other queen on bottom, right diagonal.
		for (int i = row + 1, j = col - 1 ; i < board.length && j >= 0; i++, j--) {
			if (board[i][j]) {
				return true;
			}
		}
		// Reaching this point, no intersections for this queen.
		return false;
	}
}
