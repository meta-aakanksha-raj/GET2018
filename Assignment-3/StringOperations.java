import java.util.Scanner;
class Operations {
	private String str1,str2;
	public boolean comparision(String str1, String str2) {
		boolean result;
		this.str1=str1;
		this.str2=str2;
		result=str1.equals(str2);
		return result;
	}
	
	public String reverse(String str1) {
		this.str1=str1;
		String output="";
		for(int i=(str1.length())-1;i>=0;i--) {
			output+=str1.charAt(i);
		}
		return output;
	}
	
	public String uppercase(String str1) {
		this.str1=str1;
		str1=str1.toUpperCase();
		return str1;
	}
	/*
	public int largest(String str) {
		this.str=str;
		String[] words=str.split(" ");
		int length;
		for(String word:words) {
			if(length<word.length()) {
				length=word.length();
			}
		}
		return length;
	}
	*/
}

public class StringOperations {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		Operations object=new Operations();
		while(true) {
			System.out.println("Choose from following operations: \n 1. String Comparision \n 2. Reverse String \n 3. Replace Lowercase to Uppercase \n 4. Largest Word \n 5. Exit ");
			int choice;
			choice=input.nextInt();
			switch(choice) {
				case 1: {
					String str1,str2;
					boolean output;
					System.out.print("Enter first string: ");
					str1=input.nextLine();
					System.out.print("Enter second string: ");
					str1=input.nextLine();
					output=object.comparision(str1,str2);
					System.out.print("Result of comparision: "+output);
					break;
				}
				case 2: {
					String str,output;
					System.out.print("Enter the string to reverse: ");
					str=input.nextLine();
					output=object.reverse(str);
					System.out.print("Result of Reverse: "+output);
					break;
				}
				case 3: {
					String str,output;
					System.out.print("Enter the string to covert it to uppercase: ");
					str=input.nextLine();
					output=object.uppercase(str);
					System.out.print("Result of Coversion to Uppercase: "+output);
					break;
				}
				case 4: {
					String str;
					int output;
					System.out.print("Enter the string to find largest word: ");
					str=input.nextLine();
					output=object.largest(str);
					System.out.print("Result of Reverse: "+output);
					break;
				}
				case 5: {
					System.exit(0);
				}
				default: System.out.println("Wrong input!! Try again!!");
			}
		}
	}
}