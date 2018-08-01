package system;
import java.util.Scanner;

public class ZooManagement {
	public static void main(String args[]) {
		Scanner input=new Scanner(System.in);
		while(true) {
			System.out.println("Choose your role:- \n1.Admin \n2.View Only \n3.Exit");
			int choice=input.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter password");
				String password=input.next();
				if(password.equals("aakanksha")) {
					System.out.println("Welcome to admin panel");
					break;
				}
				else {
					System.out.println("Wrong password");
					break;
				}
				
			case 2:
				System.out.println("Welcome to viewers panel");
				break;
				
			case 3:System.exit(0);
				
			default:System.out.println("Wrong choice!! Please enter correct input!");
				
				
			}
		}
	}
	
}
