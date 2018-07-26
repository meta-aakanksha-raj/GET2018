package set;

final class IntSet {
	
	final private int[] set;
	final private int length;
	
	public IntSet(int[] set) {
		this.set=set;
		this.length=set.length;
		checking(set);
	}
	
	/**IntSet(IntSet s1, IntSet s2) {
		
	}*/
	
	private int[] getArray() {
		int[] array=new int[set.length];
		for(int i=0;i<set.length;i++) {
			array[i]=set[i];
		}
		return array;
	}
	
	private void checking(int[] set) {
		if(set.length==0) {
			throw new AssertionError("Set is empty");
		}
		for(int i=0;i<set.length;i++) {
			if(set[i]<1 || set[i]>1000) {
				throw new AssertionError("Numbers are not in defined range");
			}
		}
	}
	
	public boolean isMember(int key) {
		boolean result=false;
		for(int i=0;i<set.length;i++) {
			if(set[i]==key) {
				result=true;
				break;
			}
		}
		return result;
	}
	
	public int size() {
		return length;
	}
	
	public boolean isSubSet(IntSet s) {
		int[] setOne=this.getArray();
		int[] setTwo=s.getArray();
		int count=0;
		boolean result=false;
		for(int i=0;i<this.size();i++) {
			for(int j=0;j<s.size();j++) {
				if(setOne[i]==setTwo[j]) {
					count++;
					break;
				}
			}	
		}
		if(count==this.size()) {
			result=true;
		}
		return result;
	}
	
	public int[] getComplement() {
		int k=0;
		int complementSize=15-set.length;
		int[] complement=new int[complementSize];
		
		for(int i=0;i<15;i++) {
			boolean result=false;
			for(int j=0;j<set.length;j++) {
				if((i+1)==set[j]) {
					result=true;
					break;
				}
				else {
					result=false;
				}
			}
			if(result==false) {
				complement[k]=i+1;
				k++;
			}
		}
		return complement;
	}
	
	public int[] getComplementUser() {
		int k=0;
		int complementSize=1000-set.length;
		int[] complement=new int[complementSize];
		
		for(int i=0;i<1000;i++) {
			boolean result=false;
			for(int j=0;j<set.length;j++) {
				if((i+1)==set[j]) {
					result=true;
					break;
				}
				else {
					result=false;
				}
			}
			if(result==false) {
				complement[k]=i+1;
				k++;
			}
		}
		return complement;
	}
	
	public static int[] union(IntSet s1, IntSet s2) {
		int unionLength=s1.length+s2.length;
		int k=0;
		int[] unionArray=new int[unionLength];
		for(int i=0;i<s1.length;i++) {
			unionArray[k]=s1.set[i];
			k++;
		}
		for(int i=0;i<s2.length;i++) {
			boolean result=false;
			for(int j=0;j<unionArray.length;j++) {
				if(s2.set[i]==unionArray[j]) {
					result=true;
					break;
				}
				else {
					result=false;
				}
			}
			if(result==false) {
				unionArray[k]=s2.set[i];
				k++;	
			}
		}
		return unionArray;
	}
}

