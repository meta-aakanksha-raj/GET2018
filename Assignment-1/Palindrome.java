import java.util.Scanner;
import java.util.Stack;

class Check{
	
	private Stack<Character> stack = new Stack<Character>();
	
	public boolean check_palindrome(String string){
		for(int i = 0; i < string.length(); i++){
		    stack.push(string.charAt(i));
		}
		
		String reverse = "";
		for(int i = string.length()-1; i >= 0 ; i--){
			reverse = reverse + stack.pop();
		}
		
		if(string.equals(reverse)){
			return true;
		}
		else{
			return false;
		}
	}
}


class Palindrome {
	public static void main (String args[]){
		Check object = new Check();
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter a string: ");
		String original_string = input.nextLine();
		String new_string=original_string.toLowerCase();
		boolean answer=object.check_palindrome(new_string);
		if(answer==true){
			System.out.println(original_string+" is palindrome");
		}
		else{
			System.out.println(original_string+" is not palindrome");
		}
	}
}
		