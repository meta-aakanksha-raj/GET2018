package recursion;

public class NQueenRecursion {

	/**
	 * Here chessboard is created according to the number of queens to be placed
	 * @param N for taking value for number of queens to be placed
	 * @return the array of chessboard on which queen is placed if correct value is taken else is empty
	 */
	public int[][] numberOfQueens(int N) {
		int row = 0;
		int[][] chessBoard = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				chessBoard[i][j] = 0;
			}
		}
		boolean result = nQueen(chessBoard, row, N);
		return chessBoard;
	}

	/**
	 * This method is to get all the positions where queen can be placed
	 * @param chessBoard is 2-D array in which we have to place queen
	 * @param row is for value of each row to check
	 * @param N is number of queens
	 * @return
	 */
	private boolean nQueen(int[][] chessBoard, int row, int N) {
		boolean placed = false;

		for (int column = 0; column < N; column++) {
			placed = canBePlaced(chessBoard, row, column, N);

			if (placed) {
				chessBoard[row][column] = 1;
				row++;

				if (row == N) {
					placed = true;
					break;
				}
				if (!nQueen(chessBoard, row, N)) {
					row--;
					chessBoard[row][column] = 0;
					placed = false;
				} else {
					break;
				}
			}
		}
		return placed;
	}

	/**
	 * To test whether at particular position queen can be placed or not
	 * @param chessBoard is 2-D array in which we have to place queen
	 * @param row is for value of each row to check
	 * @param column is for value of each column to check
	 * @param N is number of queens
	 * @return result whether queen can be placed or not 
	 */
	private boolean canBePlaced(int[][] chessBoard, int row, int column, int N) {
		int i, j;
		
		//checks if any queen exists in the same column
		for (i = 0; i < row; i++) {
			if (chessBoard[i][column] == 1) {
				return false;
			}
		}
		
		//checks if any queen exists in the upper left diagonal
		for (i = row, j = column; i >= 0 && j >= 0; i--, j--) {
			if (chessBoard[i][j] == 1) {
				return false;
			}
		}
		//checks if any queen exists in the upper right diagonal
		for (i = row, j = column; i >= 0 && j < N; i--, j++) {
			if (chessBoard[i][j] == 1) {
				return false;
			}
		}
		return true;
	}
}