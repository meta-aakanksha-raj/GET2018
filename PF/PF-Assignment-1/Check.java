import java.util.Scanner;
import java.util.Stack;

class Palindrome{
	
	private Stack<Character> stack = new Stack<Character>();
	
	public boolean checkPalindrome(String string)
	{
		for(int i = 0; i < string.length(); i++)
		{
		    stack.push(string.charAt(i));
		}
		
		String reverse = "";
		for(int i = string.length()-1; i >= 0 ; i--)
		{
			reverse = reverse + stack.pop();
		}
		
		if(string.equals(reverse))
			return true;
		else 
			return false;
	}
}


class Check {
	public static void main (String args[])
	{
		Palindrome object = new Palindrome();
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter a string: ");
		String s = input.nextLine();
		String str=s.toLowerCase();
		boolean answer=object.checkPalindrome(str);
		if(answer==true)
			System.out.println(s+" is palindrome");
		else
			System.out.println(s+" is not palindrome");
	}
}
		