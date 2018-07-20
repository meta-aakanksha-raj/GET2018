import java.util.Scanner;
class Operations {
	/**
	 * To input string which is case sensitive, it should not be null
	 * @return String which user has inputed
	 */
	public String inputString() {
		Scanner scan = new Scanner(System.in);
		String inputUser = scan.nextLine();
		return inputUser;
	}
	/**
	 * To compare two string whether they are equal or not	
	 * @param firstString is first user input string
	 * @param secondString is second user input string
	 * @return 1 if both strings are equal else returns 0
	 */
	public int compareTwoStrings(String firstString, String secondString) {
		if (firstString.length()!=secondString.length()){
				return 0;
		}
		else {
	        for(int i = 0; i<firstString.length();i++) {
				if(firstString.charAt(i)!=secondString.charAt(i))
					return 0;
			}
		}
		return 1;
	}
	/**
	 * To reverse a string
	 * @param inputString is string which user want to reverse
	 * @return reverse string
	 */
	public String reverseString(String inputString) {
		String reversedString = "";
		for(int i=inputString.length()-1; i>=0;i--) {
			reversedString = reversedString + inputString.charAt(i);
		}
		return reversedString;
	}
	/**
	 * Replaces lowercase letters with uppercase and vice versa 
	 * @param inputString is string which user want to change case
	 * @return changed cases of string
	 */
	public String replaceLowerUpperCase(String inputString) {
		int digit=-1;
		String changedString ="";
		for(int i=0;i<inputString.length();i++) {
			digit= (int)inputString.charAt(i);
			if(digit>64 && digit<90) {
				digit+=32;
			}
			else if(digit>96 && digit<122) {
				digit-=32;
			}
			changedString = changedString + (char)digit;
		}
		return changedString;
	}
	/**
	 * finds largest word if two words are same then return the last one
	 * @param inputString is string in which user want to find largest word
	 * @return gives the largest word
	 */
	public String largestWordInString(String string) {
		string += " ";
		int stringLength = stringLength(string);
		String newString = "", maxWord = "";
		int maxLength = 0, newStringLength;
		
		for(int i = 0; i < string.length(); i++){
			char ch = string.charAt(i);
			if(ch != ' ')
			{
				newString += ch;
			}
			else
			{
				newStringLength = newString.length();
			
				if(newStringLength >= maxLength)
				{
					maxLength = newStringLength;
					maxWord = newString;
				}
				newString = "";
			}
		}
        return maxWord;
	}
}
	
public class StringOperations {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		Operations object=new Operations();
		while(true) {
			System.out.println("\nChoose from following operations: \n 1. String Comparision \n 2. Reverse String \n 3. Replace Lowercase to Uppercase \n 4. Largest Word \n 5. Exit ");
			int choice;
			choice=input.nextInt();
			/**
			 * Choose the operations you want to perform
			 */
			switch(choice) {
				case 1: {
					String firstString="";
					String secondString="";
					int result;
					System.out.print("Enter first string: ");
					firstString = object.inputString();
					System.out.print("Enter second string: ");
					secondString = object.inputString();
					result = object.compareTwoStrings(firstString,secondString);
					System.out.print("Result of comparision: "+result);
					break;					
				}
				case 2: {
					String firstString="";
					String resultString="";
					System.out.print("Enter the string to reverse: ");
					firstString = object.inputString();
					resultString = object.reverseString(firstString);
					System.out.print("Result of Reverse: "+resultString);
					break;
				}
				case 3: {
					String firstString="";
					String resultString="";
					System.out.print("Enter the string to covert it to uppercase: ");
					firstString = object.inputString();
					resultString = object.replaceLowerUpperCase(firstString);
					System.out.print("Result of Coversion to Uppercase: "+resultString);
					break;
				}
				case 4: {
					String firstString="";
					String resultString="";
					System.out.print("Enter the string to find largest word: ");
					firstString = object.inputString();
				    resultString = object.largestWordInString(firstString);
					System.out.print("Result of Largest Word: "+resultString);
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
