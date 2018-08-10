/**
 * 
 */
package nested_list_json;

import java.util.List;
import java.util.LinkedList;

import org.json.simple.JSONArray;

/**
 * To perform various operation on nested list list like sum, search and find largest number
 *
 */
public class NestedList implements NestedListInterface {

	List<Object> listOfIntegersFinal = new LinkedList<Object>();

	static int largestIntegerInList = 0;
	
	/* (non-Javadoc)
	 * @see nested_list_json.NestedListInterface#sumOfAllIntegersInList(java.util.List)
	 */
	@Override
	public int sumOfAllIntegersInList(List<Object> nestedList) {
		int sum = 0;
		for(int index = 0;index < nestedList.size(); index++) {
			if(nestedList.get(index) instanceof String) {
				sum += Integer.parseInt((String) nestedList.get(index));
			}
			else if(nestedList.get(index) instanceof List) {
				sum += sumOfAllIntegersInList((List) nestedList.get(index));
			}
		}
		return sum;
	}

	/* (non-Javadoc)
	 * @see nested_list_json.NestedListInterface#largestIntegerInList(java.util.List)
	 */
	@Override
	public int largestIntegerInList(List<Object> nestedList) {
		for (int index = 0; index < nestedList.size(); index++) {
			if (nestedList.get(index) instanceof String) {
				if (Integer.parseInt((String) nestedList.get(index)) > largestIntegerInList) {
					largestIntegerInList = Integer.parseInt((String) nestedList.get(index));
				}
			} else if (nestedList.get(index) instanceof List) {
				largestIntegerInList = largestIntegerInList((List) nestedList.get(index));
			}
		}

		return largestIntegerInList;
	}

	/* (non-Javadoc)
	 * @see nested_list_json.NestedListInterface#searchIntegerInList(java.util.List, int)
	 */
	@Override
	public boolean searchIntegerInList(List<Object> nestedList,
			int integerUserWantToFind) {
		boolean flag = false;
		for (int index = 0; index < nestedList.size(); index++) {
			if (nestedList.get(index) instanceof String) {
				if (Integer.parseInt((String) nestedList.get(index)) == integerUserWantToFind) {
					flag = true;
					break;
				}
			} else if (nestedList.get(index) instanceof List) {
				flag = searchIntegerInList((List) nestedList.get(index), integerUserWantToFind);
				if(flag){
					break;
				}
			}
		}
		return flag;
	}

	/**
	 * To create the nested list
	 * @param listOfIntegers is the object of List<Object>
	 * @param inputArray given by user
	 * @return the created nested list
	 */
	public List<Object> createNestedList(List<Object> listOfIntegers, JSONArray inputArray) {
		int lengthOfList = inputArray.size();

		for (int indexOfList = 0; indexOfList < lengthOfList; indexOfList++) {
			if (inputArray.get(indexOfList) instanceof String) {
				//test
				listOfIntegers.add(inputArray.get(indexOfList));
			} else if (inputArray.get(indexOfList) instanceof List) {
				List<Object> branchList = new LinkedList<Object>();
				listOfIntegers.add(createNestedList(branchList, (JSONArray) inputArray.get(indexOfList)));
			}
		}
		return listOfIntegers;
	}

	/**
	 * to print the whole list
	 * @param listToPrint
	 */
	public void printNestedList(List<Object> listToPrint) {
		System.out.println(listToPrint);
	}
}
