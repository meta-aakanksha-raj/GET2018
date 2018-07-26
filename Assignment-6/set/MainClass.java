package set;

import java.util.Scanner;

public class MainClass {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		//This is for original array
		System.out.println("Enter size of set ");
		int size=input.nextInt();
		int[] set=new int[size];
		System.out.println("Enter elements ");
		for(int i=0;i<size;i++) {
			set[i]=input.nextInt();
		}
		
		//Creating object
		IntSet s = new IntSet(set);
		
		//This gives size of set
		System.out.println("Size of set "+s.size());

		//This is to search an element in set
		System.out.println("Enter element to search in set ");
		int x=input.nextInt();		
		boolean resultMember=s.isMember(x);
		System.out.println("Is number a member of set? "+resultMember);

		//This is for creating a new set
		System.out.println("Enter size of smaller set ");
		int sizeSmall=input.nextInt();
		int[] setSmall=new int[sizeSmall];
		System.out.println("Enter elements ");
		for(int i=0;i<sizeSmall;i++) {
			setSmall[i]=input.nextInt();
		}

		//Creating object
		IntSet object=new IntSet(setSmall);
		
		//This is for finding subset
		boolean resultSubset=object.isSubSet(s);
		System.out.println("Is set subset of original set? "+resultSubset);

		//This is for finding union
		System.out.println("\n Union of given set is ");
		int[] setUnion=object.union(object,s);
		for (int i = 0; i < setUnion.length; i++) {
			System.out.println(setUnion[i]);
		}		

		//This is for complement of universal array
		int[] array = s.getComplementUser();
		System.out.println("\n Compliment of given set is ");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
