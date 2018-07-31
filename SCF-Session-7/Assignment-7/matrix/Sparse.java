package matrix;

final class Sparse {
	final private int row;
	final private int column;
	final private int[][] compressedMatrix;

	/**
	 * This is default constructor
	 */
	public Sparse() {
		row = 0;
		column = 0;
		compressedMatrix = null;
	}

	/**
	 * This is parameterised constructor for converting a sparse matrix to
	 * copressed matrix
	 * 
	 * @param matrix
	 *            is the sparse matrix
	 */
	public Sparse(int[][] matrix) {
		int[][] sparseMatrix = Sparse.deepCopyArray(matrix);
		this.row = sparseMatrix.length;
		this.column = sparseMatrix[0].length;
		// checking(sparseMatrix);
		sparseMatrix = makingCompressed(sparseMatrix);
		this.compressedMatrix = new int[sparseMatrix.length][sparseMatrix[0].length];

		for (int i = 0; i < this.compressedMatrix.length; i++) {
			for (int j = 0; j < this.compressedMatrix[0].length; j++) {
				this.compressedMatrix[i][j] = sparseMatrix[i][j];
			}
		}

	}

	/**
	 * This is sparse constructor used when a matrix is passed along with the
	 * row and column
	 * 
	 * @param matrix
	 *            is the sparse matrix
	 * @param row
	 *            is row of sparse
	 * @param column
	 *            is the column of sparse
	 */
	private Sparse(int matrix[][], int row, int column) {
		int[][] deepCopyMatrice = Sparse.deepCopyArray(matrix);
		this.compressedMatrix = deepCopyMatrice;
		this.row = row;
		this.column = column;

	}

	/**
	 * This function does deep copy of passed matrix and its complexity is O(n^2)
	 * 
	 * @param passedMatrix
	 * @return a copy of passed matrix
	 */
	private static int[][] deepCopyArray(int[][] passedMatrix) {
		int[][] copiedArray = new int[passedMatrix.length][passedMatrix[0].length];
		for (int i = 0; i < passedMatrix.length; i++) {
			for (int j = 0; j < passedMatrix[0].length; j++) {
				copiedArray[i][j] = passedMatrix[i][j];
			}
		}
		return copiedArray;
	}

	/**
	 * To change the sparse matrix to compressed or densed form and its complexity is O(n^2)
	 * @param sparseMatrix
	 * @return the densed or compressed matrix
	 */
	public int[][] makingCompressed(int[][] sparseMatrix) {
		int[][] compressedMatrixNew;
		int countNumberOfZero = 0;

		for (int i = 0; i < sparseMatrix.length; i++) {
			for (int j = 0; j < sparseMatrix[0].length; j++) {
				if (sparseMatrix[i][j] == 0) {
					countNumberOfZero++;
				}
			}
		}
		int totalNumbers = sparseMatrix.length * sparseMatrix[0].length;
		int size = totalNumbers - countNumberOfZero;
		compressedMatrixNew = new int[3][size];

		for (int i = 0, k = 0; i < sparseMatrix.length
				&& k < compressedMatrixNew[0].length; i++) {
			for (int j = 0; j < sparseMatrix[0].length; j++) {
				if (sparseMatrix[i][j] != 0) {
					compressedMatrixNew[0][k] = i;
					compressedMatrixNew[1][k] = j;
					compressedMatrixNew[2][k] = sparseMatrix[i][j];
					k++;
				}
			}
		}
		return compressedMatrixNew;
	}

	/**
	 * To transpose the sparse matrix entered by user
	 * @return transpose matrix
	 */
	public int[][] transpose() {
		int[][] copyOfObjectMatrix = Sparse
				.deepCopyArray(this.compressedMatrix);
		for (int i = 0; i < this.compressedMatrix[0].length; i++) {
			int temp = copyOfObjectMatrix[0][i];
			copyOfObjectMatrix[0][i] = copyOfObjectMatrix[1][i];
			copyOfObjectMatrix[1][i] = temp;
		}
		copyOfObjectMatrix = sorting(copyOfObjectMatrix);
		return copyOfObjectMatrix;
	}

	/**
	 * To check whether the passed sparse matrix is symmetric or not
	 * @return true if matrix is symmetric otherwise return false
	 */
	public boolean symmetry() {
		int[][] compressedMatrix = Sparse.deepCopyArray(this.compressedMatrix);
		int[][] transposedMatrix = this.transpose();
		boolean result = true;
		for (int i = 0; i < compressedMatrix.length; i++) {
			for (int j = 0; j < compressedMatrix[0].length; j++) {
				if (compressedMatrix[i][j] != transposedMatrix[i][j]) {
					result = false;
					break;
				}
			}
			if (!result) {
				break;
			}
		}
		return result;
	}

	/**
	 * To add two sparse matrix
	 * @param matrixOne is the object of first matrix
	 * @param matrixTwo is the object of second matrix
	 * @return addition of the two matrices
	 */
	public static Sparse addMatrix(Sparse matrixOne, Sparse matrixTwo) {
		int[][] matrixFirst = Sparse.deepCopyArray(matrixOne.compressedMatrix);
		int[][] matrixSecond = Sparse.deepCopyArray(matrixTwo.compressedMatrix);
		int count = 0;

		for (int i = 0; i < matrixFirst[0].length; i++) {
			for (int j = 0; j < matrixSecond[0].length; j++) {
				if (matrixFirst[0][i] == matrixSecond[0][j]
						&& matrixFirst[1][i] == matrixSecond[1][j]) {
					matrixFirst[2][i] = matrixFirst[2][i] + matrixSecond[2][j];
					matrixSecond[0][j] = -1;
					count++;
				}
			}
		}

		int newLength = (matrixFirst[0].length) + (matrixSecond[0].length)
				- count;
		int[][] matrixThree = new int[3][newLength];
		int i = 0;
		for (int j = 0; i < newLength && j < matrixFirst[0].length; i++, j++) {
			matrixThree[0][i] = matrixFirst[0][j];
			matrixThree[1][i] = matrixFirst[1][j];
			matrixThree[2][i] = matrixFirst[2][j];

		}

		for (int j = 0; i < newLength && j < matrixSecond[0].length; j++) {
			if (matrixSecond[0][j] != -1) {
				matrixThree[0][i] = matrixSecond[0][j];
				matrixThree[1][i] = matrixSecond[1][j];
				matrixThree[2][i] = matrixSecond[2][j];

			}

		}
		Sparse objectToBeReturned = new Sparse(matrixThree, matrixOne.row,
				matrixTwo.column);
		Sparse.display(matrixThree);
		return objectToBeReturned;

	}

	/**
	 * To sort the matrix row wise
	 * @param matrix 
	 * @return sorted matrix
	 */
	private int[][] sorting(int[][] matrix) {
		int length = matrix[0].length;
		for (int i = 0; i < length - 1; i++) {
			for (int j = 0; j < length - i - 1; j++) {
				if (matrix[0][j] > matrix[0][j + 1]) {
					int swapRow = matrix[0][j];
					int swapColumn = matrix[1][j];
					int swapNumber = matrix[2][j];
					matrix[0][j] = matrix[0][j + 1];
					matrix[1][j] = matrix[1][j + 1];
					matrix[2][j] = matrix[2][j + 1];
					matrix[0][j + 1] = swapRow;
					matrix[1][j + 1] = swapColumn;
					matrix[2][j + 1] = swapNumber;
				}
			}
		}
		return matrix;
	}

	/**
	 * To display the matrix passed
	 * @param matrix
	 */
	public static void display(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}

	/**
	 * To check whether two matrices are equal or not
	 * @param matrixOne
	 * @param matrixTwo
	 * @return true if both are equal else false
	 */
	public static boolean checkEqual(Sparse matrixOne, Sparse matrixTwo) {
		boolean flag = false;
		int[][] copyMatrixOne = Sparse
				.deepCopyArray(matrixOne.compressedMatrix);
		int[][] copyMatrixTwo = Sparse
				.deepCopyArray(matrixTwo.compressedMatrix);
		for (int i = 0, j = 0; j < copyMatrixTwo[0].length; i++, j++) {
			if ((copyMatrixTwo[0][i] != copyMatrixOne[0][j])
					&& (copyMatrixTwo[1][i] != copyMatrixOne[1][j])
					&& (copyMatrixTwo[2][i] != copyMatrixOne[2][j])) {
				flag = true;
				break;
			}
		}

		return flag;
	}

	/**
	 * To multiply two sparse matrix
	 * @param firstMatrix is the object of first matrix
	 * @param secondMatrix is the object of second matrix
	 * @return multiplication of two matrix
	 */
	public int[][] multiplyMatrix(Sparse firstMatrix, Sparse secondMatrix) {
		int[][] multiplyMatrix = new int[firstMatrix.row][secondMatrix.column];

		if (firstMatrix.column != secondMatrix.row) {
			throw new AssertionError("can't multiply matrix dimension mismatch");
		}

		for (int i = 0; i < firstMatrix.row; i++) {
			for (int j = 0; j < secondMatrix.column; j++) {
				multiplyMatrix[i][j] = 0;
			}
		}

		for (int i = 0; i < firstMatrix.compressedMatrix[0].length; i++) {
			for (int j = 0; j < secondMatrix.compressedMatrix[0].length; j++) {
				if (firstMatrix.compressedMatrix[1][i] == secondMatrix.compressedMatrix[0][j]) {
					multiplyMatrix[firstMatrix.compressedMatrix[0][i]][secondMatrix.compressedMatrix[1][j]] += (firstMatrix.compressedMatrix[2][i] * secondMatrix.compressedMatrix[2][j]);
				}
			}
		}
		return multiplyMatrix;
	}
}
