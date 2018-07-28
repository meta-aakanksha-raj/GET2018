package matrix;

import java.util.Scanner;

public class MainSparse {
	static Scanner input = new Scanner(System.in);

	/**
	 * This function is to take input for matrix
	 * @return the matrix
	 */
	public static int[][] make() {
		System.out.println("Enter number of rows for matrix ");
		int row = input.nextInt();
		System.out.println("Enter number of columns for matrix  ");
		int column = input.nextInt();
		System.out.println("Enter elements ");
		int[][] matrix = new int[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				matrix[i][j] = input.nextInt();
			}
		}
		return matrix;
	}

	public static void main(String args[]) {
		
		//This is for multiplying two sparse matrix
		int[][] multiplyOne = make();
		int[][] multiplyTwo = make();
		Sparse s5 = new Sparse(multiplyOne);
		Sparse s6 = new Sparse(multiplyTwo);
		System.out.println("\n resultant matrix after multiplication ");
		Sparse s7 = new Sparse();
		int[][] multiplication = s7.multiplyMatrix(s5, s6);
		s7.display(multiplication);
		
		int[][] mainMatrix = make();

		//This is for Sparse matrix
		Sparse s1 = new Sparse(mainMatrix);
		System.out.println("\n Sparse Matrix- ");
		s1.display(mainMatrix);

		//This is for compressed matrix representation
		int[][] compressed = s1.makingCompressed(mainMatrix);
		System.out.println("\n Compressed Matrix- ");
		s1.display(compressed);

		//This is for transpose of main matrix
		int[][] transpose = s1.transpose();
		System.out.println("\n Transpose Matrix- ");
		s1.display(transpose);

		//This is to check whether main matrix is symmetric or not
		boolean result = s1.symmetry();
		System.out.println("\n Is this symmetrical Matrix? - " + result);

		//This is for adding two sparse matrix
		int[][] firstMatrix = make();
		int[][] secondMatrix = make();
		Sparse s2 = new Sparse(firstMatrix);
		Sparse s3 = new Sparse(secondMatrix);
		System.out.println("\n resultant matrix after addition ");
		Sparse s4 = Sparse.addMatrix(s2, s3);


	}
}