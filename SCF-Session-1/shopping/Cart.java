package shopping;

import java.util.Scanner;

/**
 * This is basically a interface for user where menu of cart is shown to user
 * and user has to choose from the options provided
 * 
 * @author Aakanksha
 */
public class Cart {
	public static void main(String arg[]) {
		ShoppingCart cart = new ShoppingCart();
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.println("*****************SHOPPING CART*******************");
		System.out.println();
		int choice;
		do {
			System.out.println();
			System.out.println("MENU");
			System.out.println("1. Add item to cart \n"
					+ "2. Remove an item from cart \n" + "3. Generate bill \n"
					+ "4. Exit \n" + "Enter your Choice ");

			choice = input.nextInt();
			switch (choice) {
			case 1:
				System.out.println();
				System.out
						.println("For adding the product to your cart do the required procedures:- ");
				System.out.print("Enter the product id of the item:- ");
				int id = input.nextInt();
				System.out.println();
				System.out.print("Enter the price of the item:- ");
				double price = input.nextDouble();
				System.out.println();
				System.out.print("Enter the quantity of the item:- ");
				int quantity = input.nextInt();
				System.out.println();
				cart.addItem(id, price, quantity);
				break;

			case 2:
				System.out.println();
				System.out.println("Enter the id of the item to be removed:");
				int idProduct = input.nextInt();
				cart.removeItem(idProduct);
				break;

			case 3:
				System.out
						.println("Do you have any promocode? \n Enter 'y' for yes 'n' for no");
				char answer = input.next().charAt(0);
				String promocode = "";
				if (answer == 'y') {
					System.out.println("Enter the promocode you have : ");
					promocode = input.next();
				}
				System.out.println("Total billing of your purchase : ");
				cart.generateBill(promocode);
				break;

			case 4:
				System.out.println();
				System.out.println("Exiting....");
				System.out.println("Thankyou! Please come again");
				break;

			default:
				System.out.println("Wrong input! Try again!!");
			}
		} while (choice != 4);
	}
}
