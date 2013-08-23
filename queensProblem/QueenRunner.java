package queensProblem;

public class QueenRunner {

	public static void main(String[] args) {
		test_1();
	}
	
	private static void test_1 () {
		boolean[][] board = new boolean[8][8];
		QueenSolver.solveQueenPuzzle(board);
		printBoard(board);
		
	}
	
	private static void printBoard(boolean[][] board) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < board[0].length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[j][i]) {
					builder.append("Q");
				}
				else {
					builder.append(".");
				}
			}
			builder.append("\n");
		}
		System.out.println(builder.toString());
	}

}
