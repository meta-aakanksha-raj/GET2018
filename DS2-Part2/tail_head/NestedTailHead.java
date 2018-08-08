package tail_head;

import java.util.List;

/**
 * This is the class to extract an integer value from a specified position in the nested list
 */
public class NestedTailHead {

	/**
	 * This method to extract an integer value from a specified position in the nested list
	 * 
	 * @param pattern of head tail
	 * @param inputList is the list of integers or list
	 * @return the value of specified position
	 */
	public static int getValue(String pattern, List<Object> inputList) {
		int value = -1;

		// This loop is for pattern of TH
		for (int index = 0; index < pattern.length(); index++) {
			if (pattern.charAt(index) == 'H') {
				// Here element at 0th position is taken and passed to object
				Object objectOfObject = inputList.get(0);
				// Here pattern length is checked, if it is one less than index
				if (index == pattern.length() - 1) {
					// Here object is checked, if it is of list type then throws error

					if (objectOfObject instanceof List) {
						throw new AssertionError("ERROR");
						// if it is not the converted to integer type and stored
					} else {
						value = (Integer) objectOfObject;
						break;
					}

				} else {
					// If the object is of list type the getValue method is
					// called recursively, and substring is passed as pattern
					if (objectOfObject instanceof List) {
						value = getValue(pattern.substring(index + 1, pattern.length()),(List) objectOfObject);
						break;
					} else {
						throw new AssertionError("ERROR");
					}
				}
			}
			// If T comes then remove that from list
			else if (pattern.charAt(index) == 'T') {
				inputList.remove(0);
			} else {
				throw new AssertionError();
			}
		}
		return value;
	}
}
