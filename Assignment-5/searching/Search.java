package searching;

public class Search {
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
