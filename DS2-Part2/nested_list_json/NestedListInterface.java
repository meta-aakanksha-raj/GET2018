package nested_list_json;

import java.util.List;

/**
 * Class to implement nested list functionalities like sum, largest number and search an element using JSON
 */
public interface NestedListInterface {

	/**
	 * Calculate and return sum of all integers in list
	 * @param nestedList is the nested list passed whose sum user has to find
	 * @returnsum of all integer elements in list
	 */
	public int sumOfAllIntegersInList(List<Object> nestedList);

	/**
	 * Find and return largest integer in the list
	 * @param nestedList is the nested list passed from which user has to find the largest number
	 * @returnlargest integer in the list
	 */
	public int largestIntegerInList(List<Object> nestedList);

	/**
	 * Find element given by user in list
	 * @param nestedList is the nested list passed in which user has to find the number
	 * @param integerUserWantToFind
	 * @return boolean value true if element is in list, otherwise false
	 */
	public boolean searchIntegerInList(List<Object> nestedList, int integerUserWantToFind);
}