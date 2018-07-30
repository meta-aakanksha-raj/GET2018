package recursion;

public class NQueenRecursion {

	/**
	 * Here chessboard is created according to the number of queens to be placed
	 * @param dimensionOfMatrix is the dimension of board
	 * @return the array of chessboard on which queen is placed if correct value is taken else is empty
	 */
	public int[][] numberOfQueens(int dimensionOfMatrix) {
		int startRow = 0;
		int[][] board = new int[dimensionOfMatrix][dimensionOfMatrix];
		for (int i = 0; i < dimensionOfMatrix; i++) {
			for (int j = 0; j < dimensionOfMatrix; j++) {
				board[i][j] = 0;
			}
		}
		boolean result = nQueen(board, startRow, dimensionOfMatrix);
		return board;
	}

	/**
	 * This method is to get all the positions where queen can be placed
	 * @param board is 2-D array in which we have to place queen
	 * @param row is for value of each row to check
	 * @param dimensionOfMatrix is the dimension of board
	 * @return
	 */
	private boolean nQueen(int[][] board, int row, int dimensionOfMatrix) {
		boolean placed = false;

		for (int column = 0; column < dimensionOfMatrix; column++) {
			placed = canBePlaced(board, row, column, dimensionOfMatrix);

			if (placed) {
				board[row][column] = 1;
				row++;

				if (row == dimensionOfMatrix) {
					placed = true;
					break;
				}
				if (!nQueen(board, row, dimensionOfMatrix)) {
					row--;
					board[row][column] = 0;
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
	 * @param board is 2-D array in which we have to place queen
	 * @param row is for value of each row to check
	 * @param column is for value of each column to check
	 * @param dimensionOfMatrix is the dimension of board
	 * @return result whether queen can be placed or not 
	 */
	private boolean canBePlaced(int[][] board, int row, int column, int dimensionOfMatrix) {
		int i, j;
		boolean result=true;
		
		//checks if any queen exists in the same column
		for (i = 0; i < row; i++) {
			if (board[i][column] == 1) {
				result=false;
			}
		}
		
		//checks if any queen exists in the upper left diagonal
		for (i = row, j = column; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1) {
				result=false;
			}
		}
		//checks if any queen exists in the upper right diagonal
		for (i = row, j = column; i >= 0 && j < dimensionOfMatrix; i--, j++) {
			if (board[i][j] == 1) {
				result=false;
			}
		}
		return result;
	}
}
