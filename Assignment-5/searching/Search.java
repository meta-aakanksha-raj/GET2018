package searching;

public class Search {

	/**
	 * To search for an element in an array one by one through linear search
	 * @param array is array passed in which we have to find the element
	 * @param element is the key which we need to search
	 * @param index is the staring index of array
	 * @return the index at which we found the element if not found returns -1
	 */
	public int linear(int[] array, int element,int index) {
        if(array.length == 0) {
			throw new AssertionError("Array empty");
        }
        
		int position=-1;
		if(index>=array.length) {
			return position;
		}
		if(array[index]==element) {
			position=index;
		}
		else {
			position=linear(array, element, index+1);
		}
		return position;
	}

	/**
	 * To search for an element in an array by binary search
	 * @param sortedArray is the sorted array in which we have to find the element
	 * @param start is the starting index
	 * @param end is the index of last element
	 * @param element is the number which needs to be searched
	 * @return the index value of the element if found else returns -1
	 */
    public int binary(int[] sortedArray, int start, int end, int element) {
    	
        if(sortedArray.length == 0) {
			throw new AssertionError("Array empty");
        }
        if (start > end) {
        	return -1;
        }
        int mid = ( start + end ) / 2;
        
        if(sortedArray[mid]==element) {
            return mid;
        }
        else if (element < sortedArray[mid]) {
        	return binary(sortedArray, start, mid-1, element);    
        } 
        else {
            return binary(sortedArray, mid+1, end , element);       
        }   
    }
}
