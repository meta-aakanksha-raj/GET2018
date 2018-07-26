package recursion;
import java.util.Scanner;

public class NQueenMain {
	public static void main(String args[]) {
		Scanner input=new Scanner(System.in);
		NQueenRecursion object=new NQueenRecursion();
		System.out.println("Enter size of board");
		int size=input.nextInt();
		int[][] chessBoard=new int[size][size];
		chessBoard=object.numberOfQueens(size);
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				System.out.print(chessBoard[i][j]);
			}
			System.out.println();
		}
	}
}
