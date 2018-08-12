import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * To check the unique characters in string
 */
public class StringUniqueCharacterCheck {
	HashMap<String,Integer> map = new HashMap<String,Integer>();

	/**
	 * a method that takes a string and returns the number of unique characters in the string.
	 * @param stringWithAStatement is the string passed
	 * @return the count of unique elements
	 */
	public int findTheUniqueCharacterIn(String stringWithAStatement)
	{
		Set<Character> uniqueCharacterSet = new HashSet<Character>();
		if(map.containsKey(stringWithAStatement)){
			return map.get(stringWithAStatement);
		}
		else
		{
			for(int index=0;index<stringWithAStatement.length();index++)
			{
				if(stringWithAStatement.charAt(index)==32){
					continue;
				}
				uniqueCharacterSet.add(stringWithAStatement.charAt(index));
			}
			
			map.put(stringWithAStatement, uniqueCharacterSet.size());
			return uniqueCharacterSet.size();
		}
	}

	/**
	 * Main class to check for the hashmap whether duplicate string characters are stored or not
	 */
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		StringUniqueCharacterCheck obj = new StringUniqueCharacterCheck();
		int count = obj.findTheUniqueCharacterIn("Hello Ajay Kumar Vijay");
		System.out.println(count);
		count = 1;
		count = obj.findTheUniqueCharacterIn("Hello Ajay Kumar Vijay");
		System.out.println(count);
		
		System.out.println("Enter your string:-");
		String checkStringOne = input.nextLine();
		count = obj.findTheUniqueCharacterIn(checkStringOne);
		System.out.println(count);
		count = 1;
		
		System.out.println("Enter your string:-");
		String checkStringTwo = input.nextLine();
		count = obj.findTheUniqueCharacterIn(checkStringTwo);
		System.out.println(count);	
	}
}