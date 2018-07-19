import java.util.Scanner;


class Node {
	int value;
	Node link;
	
	public Node(int val)
	{
		value = val;
	}
	
}

class StackLinkedList {
	
	Node top = null;
	
	public void push(int value)
	{ 
		if(top==null)
		{
			top = new Node(value);
			top.link = null;
		}
		else
		{
			Node newNode = new Node(value);
			newNode.link = top;
			top = newNode;
		}
	}
	
	public int pop()
	{
		if(top == null)
		{
			System.out.println("The Stack is empty! Cannot pop!");
			return -1;
		}
		
		int val = top.value;
		Node popNode=top;
		top=popNode.link;
		popNode.link=null;
		return val;
	}
	
	public int topValue()
	{
		int val=top.value;
		return val;
	}
	
	public boolean isEmpty()
	{
		if(top == null)
			return true;
		else
			return false;
	}
}




class LinkedList 
{
	public static void main (String args[])
	{
		StackLinkedList object = new StackLinkedList();
		int choice,val;
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("OPTIONS:- ");
			System.out.println("1. Push");
			System.out.println("2. Pop");
			System.out.println("3. Top Value");
			System.out.println("4. Empty?");
			System.out.println("5. Exit");
			System.out.println("Enter your choice:");
			choice = sc.nextInt();
			
			switch(choice)
			{
				case 1: System.out.println("Enter value to be pushed:");
						val=sc.nextInt();
						object.push(val);
						break;
						
				case 2: val=object.pop();
						if(val!=-1)
							System.out.println("The popped value is: "+val);
						break;
						
				case 3: if(!object.isEmpty())
						{	
							val=object.topValue();
							System.out.println("The top value is: "+val);
						}
						else
							System.out.println("The stack is empty!");
						break;
						
				case 4: boolean isempty=object.isEmpty();
						if(isempty==true)
							System.out.println("The stack is empty");
						else
							System.out.println("The stack is not empty");
						break;
						
				case 5: System.exit(0);
				
				default: System.out.println("Wrong choice..\n Please enter the correct option");
			}
		}
	}
}