/**
 * 
 */
package nested_list;

import java.util.List;
import java.util.ArrayList;

/**
 * To implement the functionalities of Nested list to evaluate sum, largest number and perform search
 *
 */
public class NestedList implements ListFunctionality {

	List<List<Integer>> listOfList;
	
	public NestedList() {
		listOfList = new ArrayList<>();
	}
	
    public void addInnerList(List<Integer> list) {
        listOfList.add(list);
    }
	
	/* (non-Javadoc)
	 * @see nested_list.ListFunctionality#sum()
	 */
	@Override
	public int sum() {
		int sum=0;
		for(List<Integer> list : listOfList) {
			for(Integer object : list) {
				sum = sum + object;
			}
		}
		return sum;
	}

	/* (non-Javadoc)
	 * @see nested_list.ListFunctionality#largest()
	 */
	@Override
	public int largest() {
		int largestNumber = 0;
		for(List<Integer> list : listOfList) {
			for(Integer object : list) {
				if(largestNumber < object) {
					largestNumber = object;
				}
			}
		}
		return largestNumber;
	}

	/* (non-Javadoc)
	 * @see nested_list.ListFunctionality#search(int)
	 */
	@Override
	public boolean search(int value) {
		boolean result = false;
		for(List<Integer> list: listOfList) {
			for(Integer object : list) {
				if(object == value) {
					result = true;
				}
			}
		}
		return result;
	}
}
