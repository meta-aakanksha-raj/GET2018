package operations;

public class StringOperations {
	/**
	 * For comparing two strings whether they are equal or not
	 * @param firstString, is first string
	 * @param secondString, is second string
	 * @return 0, when string is not equal else return 1, when string is equal
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
	 * For reversing the string
	 * @param inputString, is the string to reverse
	 * @return reversed string
	 */
	public String reverseString(String inputString) {
		String reversedString = "";
		for(int i=inputString.length()-1; i>=0;i--) {
			reversedString = reversedString + inputString.charAt(i);
		}
		return reversedString;
	}

	/**
	 * To convert uppercase to lowercase and vice versa 
	 * @param inputString, is string to convert
	 * @return changed case of string 
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
	 * To find largest word
	 * @param string is input string to find the largest word
	 * @return largest word, if two words are of same length returns last word
	 */
	public String largestWordInString(String string) {
		string += " ";
		int stringLength = string.length();
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