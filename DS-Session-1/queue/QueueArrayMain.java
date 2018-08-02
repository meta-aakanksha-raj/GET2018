package queue;

import java.util.Scanner;

/**
 * This is main class for queue through which user will interact
 */
public class QueueArrayMain {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter size of array");
		int size = input.nextInt();
		QueueArray arrayObject = new QueueArray(size);

		while (true) {
			System.out.println("\nChoose option:-");
			System.out.println("1.Push  " + "2.Pop  " + "3.Full  "
					+ "4.Empty  " + "5.Display elements  " + "6.To exit  \n");
			int response = input.nextInt();

			switch (response) {
			case 1: {
				System.out.println("Enter the value you want to push");
				int value = input.nextInt();
				arrayObject.add(value);
				break;
			}
			case 2: {
				System.out.println("Popped Element = " + arrayObject.delete());
				break;
			}
			case 3: {
				System.out.println("Full status = " + arrayObject.isFull());
				break;
			}
			case 4: {
				System.out.println("Empty status = " + arrayObject.isEmpty());
				break;
			}
			case 5: {
				arrayObject.display();
				break;
			}
			case 6: {
				System.out.println("Exiting...");
				System.exit(0);
			}
			default: {
				System.out.println("Wrong input");
			}
			}
		}
	}
}
