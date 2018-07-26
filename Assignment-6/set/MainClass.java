package set;
import java.util.Scanner;

public class MainClass {
	public static void main(String args[]){
		Scanner input=new Scanner(System.in);
		IntSet object=new IntSet(new int[]{2,3,5,7,6,9,13});
		int[] array=object.getComplementUser();
		System.out.println();
		for(int i=0;i<993;i++){
			System.out.println(array[i]);
		}
	}

}
