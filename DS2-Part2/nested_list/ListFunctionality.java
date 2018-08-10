package nested_list;

/**
 * This list provide the different functionalities to implement on nested list
 *
 */
public interface ListFunctionality {

	/**
	 * To add all the elements of nested list which will store only integer values
	 * 
	 * @return the sum of all the elements of nested list in integer type, if
	 *         the values entered are not of integer type then throws error
	 */
	public int sum();

	/**
	 * To find largest element of nested list which will store only integer values
	 * 
	 * @return the largest value of the nested list in integer type if the
	 *         values entered are not of integer type then throws error
	 */
	public int largest();

	/**
	 * To search an element in nested list which will store only integer values
	 * 
	 * @param value is the integer value which needed to be searched in the list
	 * @return true if element is found else return false, if the values entered
	 *         are not of integer type then throws error
	 */
	public boolean search(int value);
}
