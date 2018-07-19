import java.util.Scanner;

class StackFunctions{
	private int arr[];
	private int size;
	private int top=-1;
	
	public StackFunctions(){}
	
	public StackFunctions(int n){
        this.size = n;
        arr = new int[size];
    }
	
	public boolean isEmpty(){
		if (top==-1){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean isFull(){
		if (top==size-1){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void push(int value){
		if (isFull()){
			System.out.println("Stack is full. No element can be inserted");
		}
		else{
			top=top+1;
			arr[top]=value;
		}
	}
	
	public int pop(){
		if (isEmpty()){
			System.out.println("Stack is empty. No element can be popped");
			return 0;
		}
		else{
			int value;
			value=arr[top];
			top=top-1;
			return value;
		}
	}
	
	public void display(){
		System.out.print("\nStack = ");
		for (int i = top; i >= 0; i--){
            System.out.print(arr[i]+" ");
		}
    System.out.println();	
	}	
}

public class Stack{

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter size of array");
		int n=input.nextInt();
		StackFunctions stackob=new StackFunctions(n);
		
		while(true){
			System.out.println("Choose option:-");
			System.out.println("1.Push  "
					+ "2.Pop  "
					+ "3.Full  "
					+ "4.Empty  "
					+ "5.Display elements  "
					+ "6.To exit  \n");
			int choice=input.nextInt();
			
			switch(choice){
				case 1:{
					System.out.println("Enter the value you want to push");
					int value=input.nextInt();
					stackob.push(value);
					break;
				}
				case 2:{
					 System.out.println("Popped Element = " + stackob.pop());
					 break;
				}
				case 3:{
					System.out.println("Full status = " + stackob.isFull());
	                break;
				}
				case 4:{
					System.out.println("Empty status = " + stackob.isEmpty());
	                break;
				}
				case 5:{
					stackob.display();
					break;
				}
				case 6:{
					System.exit(0);
				}
				default:{
					System.out.println("Wrong input");
				}
			}
		}
	}

}
