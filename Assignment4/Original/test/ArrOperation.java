package test;

public class ArrOperation {
	/**
	 * To count clumps in array
	 * @param array, is the array passed as input
	 * @param arrayLength, is the length of array 
	 * @return the clumps from array,else if array is empty, throws assertion error
	 */
	public int countClumps (int[] array,int arrayLength) {
		if(arrayLength == 0) {
			throw new AssertionError("Array is empty");
		}
		int count=0;
		for(int i=0;i<arrayLength-1;i++) {
			if(array[i]==array[i+1]) {
				count++;	
				for(int j=i+1;j<arrayLength-1;j++) {
					if(array[j]!=array[j+1]) {
						break;
					}
					i=j;
				}
			}
		}
		return count;
	}

	/**
	 * To provide index from where the split will occur in array such that ,
	 * both sides have same sum values
	 * @param array, is the array passed as input
	 * @param arrayLength, is the length of array 
	 * @return the splitting index from array,else if array is empty, throws assertion error
	 */
	public int split (int[] array,int arrayLength) {
		int firstSum=0,result=-1;
		if(arrayLength == 0) {
			throw new AssertionError("Array is empty");
		}			
		for(int i=0;i<arrayLength;i++) {
			firstSum=firstSum+array[i];
			int lastSum=0;
			for(int j=i+1;j<arrayLength;j++) {
				lastSum=lastSum+array[j];	
			}
			if(firstSum==lastSum) {
				result=i+1;
				break;
			}
		}
		return result;
	}

	/**
	 * To return size of largest mirror section found in the array 
	 * @param array, is the array passed as input
	 * @param arrayLength, is the length of array
	 * @return size of largest mirror section,else if array is empty, throws assertion error
	 */
	public int maxMirror(int[] array, int arrayLength) {
		if(arrayLength == 0) {
			throw new AssertionError("Array is empty");
		}
		int max=0;
		for(int i=0;i<arrayLength;i++) {		
			
			for(int j=arrayLength-1; j>=0;j--) {
				int count=0;
				int start=i,end=j;;
				while(start<arrayLength && end>=0 && array[start]==array[end]) {					
					count++;
					start++;
					end--;
				}
				if(max<count){	
					max=count;
				}
			}
		}
		return max;
	}	

	/**
	 * To calculate number of occurence of x and y in array,if unequal throws assertion error
	 * if unequal, throws assertion error
	 * @param array, is the array passed as input
	 * @param arrayLength, is the length of array
	 * @param x, is the first value passed from interchange function
	 * @param y,is the second value passed from interchange function
	 */
	public void unequalXY (int[] array,int arrayLength,int x,int y) {
		int countX=0,countY=0;
		for(int i=0;i<arrayLength;i++) {
			if(x==array[i]) {
				countX++;
			}
			if(y==array[i]) {
				countY++;
			}
		}
		if(countX!=countY) {
			throw new AssertionError("Unequal number of X and Y");
		}
	}

	/**
	 * To find two adjacent x values,if found throws assertion error
	 * @param array, is the array passed as input
	 * @param arrayLength, is the length of array
	 * @param x, is the first value passed from interchange function
	 * @param y,is the second value passed from interchange function
	 */
	public void adjacentX (int[] array,int arrayLength,int x,int y) {
		for(int i=0;i<arrayLength-1;i++) {
			if(x==array[i] && x==array[i+1]) {
				throw new AssertionError("Unequal number of X and Y");
			}
		}		
	}

	/**
	 * To fix Y such that Y always comes after X
	 * @param array, is the array passed as input
	 * @param arrayLength, is the length of array
	 * @param x, it is the value whose index is fixed
	 * @param y, it is the value which should be moved after every x
	 * @return array  with swapped y values
	 */
	public int[] interchange (int[] array,int arrayLength,int x,int y) {
		if(arrayLength == 0) {
			throw new AssertionError("Array is empty");
		}
		if(x==array[arrayLength-1]) {
			throw new AssertionError("X is at last position");
		}		
		unequalXY(array,arrayLength,x,y);
		adjacentX(array,arrayLength,x,y);
		for(int i=0;i<arrayLength-1;i++) {
			if(x==array[i] && y!=array[i+1]) {
				for(int j= 1;j< arrayLength;j++) {
					if(y==array[j] && x!= array[j-1]) {
						int temp;
						temp=array[j];
						array[j]=array[i+1];
						array[i+1]=temp;
					}
				}				
			}
		}
		if (array[0]==y) {
			for(int i=arrayLength-2;i>=0;i--) {
				if(x==array[i]) {
					int temp;
					temp=array[i+1];
					array[i+1]=array[0];
					array[0]=temp;
					break;
				}
			}
		}
		return array;
	}	
}