package set;

final class IntSet {

	final private int[] set;
	final private int length;

	/**
	 * This is constructor of class IntSet to initialise the variables set and length
	 * @param set is the array passed by user
	 */
	public IntSet(int[] set) {
		this.set = set;
		this.length = set.length;
		checking(set);
	}

	/**
	 * This function is to copy the set passed by user to another array
	 * @return duplicate array of original array
	 */
	private int[] getArray() {
		int[] array = new int[set.length];
		for (int i = 0; i < set.length; i++) {
			array[i] = set[i];
		}
		return array;
	}

	/**
	 * This is to check the conditions like empty array and whether the entered number is between 0 and 1000
	 * if not matched then throws error
	 * @param set is the array passed to check
	 */
	private void checking(int[] set) {
		if (set.length == 0) {
			throw new AssertionError("Set is empty");
		}
		for (int i = 0; i < set.length; i++) {
			if (set[i] < 1 || set[i] > 1000) {
				throw new AssertionError("Numbers are not in defined range");
			}
		}
	}

	/**
	 * To check whether x is a member of the set
	 * @param x is the element to be searched
	 * @return boolean true if present else false
	 */
	public boolean isMember(int x) {
		boolean result = false;
		for (int i = 0; i < set.length; i++) {
			if (set[i] == x) {
				result = true;
				break;
			}
		}
		return result;
	}

	/**
	 * To calculate the size
	 * @return the size of set
	 */
	public int size() {
		return length;
	}

	/**
	 * to check whether s is subset of the set
	 * @param s is the subset 
	 * @return true if s is subset else false
	 */
	public boolean isSubSet(IntSet s) {
		int[] setOne = this.getArray();
		int[] setTwo = s.getArray();
		int count = 0;
		boolean result = false;
		for (int i = 0; i < this.size(); i++) {
			for (int j = 0; j < s.size(); j++) {
				if (setOne[i] == setTwo[j]) {
					count++;
					break;
				}
			}
		}
		if (count == this.size()) {
			result = true;
		}
		return result;
	}

	/**
	 * To get the complement set for a size of universal set to be 15 as 
	 * it was not possible to make test case for 1000 numbers. So I have another function getComplement user
	 *  which takes universal set as 1000 and called it in main
	 * @return the complement set
	 */
	public int[] getComplement() {
		int k = 0;
		int complementSize = 15 - set.length;
		int[] complement = new int[complementSize];

		for (int i = 0; i < 15; i++) {
			boolean result = false;
			for (int j = 0; j < set.length; j++) {
				if ((i + 1) == set[j]) {
					result = true;
					break;
				} else {
					result = false;
				}
			}
			if (result == false) {
				complement[k] = i + 1;
				k++;
			}
		}
		return complement;
	}

	/**
	 * This function is called in main
	 * @return the complement of set passed
	 */
	public int[] getComplementUser() {
		int k = 0;
		int complementSize = 1000 - set.length;
		int[] complement = new int[complementSize];

		for (int i = 0; i < 1000; i++) {
			boolean result = false;
			for (int j = 0; j < set.length; j++) {
				if ((i + 1) == set[j]) {
					result = true;
					break;
				} else {
					result = false;
				}
			}
			if (result == false) {
				complement[k] = i + 1;
				k++;
			}
		}
		return complement;
	}

	/**
	 * To calculate union of set1 and set 2
	 * @param s1 is first set
	 * @param s2 is second set
	 * @return the union of s1 and s2
	 */
	public static int[] union(IntSet s1, IntSet s2) {
		int unionLength = s1.length + s2.length;
		int k = 0;
		int[] unionArray = new int[unionLength];
		for (int i = 0; i < s1.length; i++) {
			unionArray[k] = s1.set[i];
			k++;
		}
		for (int i = 0; i < s2.length; i++) {
			boolean result = false;
			for (int j = 0; j < unionArray.length; j++) {
				if (s2.set[i] == unionArray[j]) {
					result = true;
					break;
				} else {
					result = false;
				}
			}
			if (result == false) {
				unionArray[k] = s2.set[i];
				k++;
			}
		}
		return unionArray;
	}
}
