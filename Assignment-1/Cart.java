import java.util.ArrayList;
import java.util.Scanner;

class Item{
	private String name;
	private double price;
	private int quantity;
	
	public Item(String name,double price, int quantity){
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price){
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity){
		this.quantity = quantity;
	}

	public double total(){
		return price*quantity;
	}
	
	public void showItem(){
		System.out.println(name+"\t\t\t"+price+"\t\t"+quantity+"\t\t"+total());
	}
}

class ShoppingCart{
	ArrayList<Item> items = new ArrayList<Item>();
	
	public void addItem(String name, double price, int quantity){
		int update = 0;
		for(Item i : items){
			if(i.getName().equals(name)){
				update = 1;
				int q = i.getQuantity();
				i.setQuantity(quantity + q);
				break;
			}
		}
		if(update == 0){
		Item item = new Item(name, price, quantity);
		items.add(item);
		}
		System.out.println("Item is added to the Cart");
	}
	
	public void removeItem(String name){
		for(Item i:items){
			if(name.equals(i.getName())){
				items.remove(i);
				break;
			}
		}
		System.out.println("Item is removed from the Cart");
	}
	
	public void generateBill(){
		double sum=0;
		System.out.println("name\t\t\tprice\t\tquantity\ttotal");
		for(Item i:items){
			i.showItem();
			sum += i.total();
		}
		System.out.println();
		System.out.println("Grand Total:  " + sum);
	}
}

class Cart{
	public static void main (String arg[]){
	ShoppingCart cart = new ShoppingCart();
	Scanner input = new Scanner(System.in);
	int choice;	
	do{
		System.out.println();
		System.out.println("MENU");
		System.out.println("1. Add item to cart \n"
		+"2. Remove an item from cart \n"
		+"3. Generate bill \n"
		+"4. Exit \n"
		+"Enter your Choice \n");
		
		choice = input.nextInt();
		switch(choice){
		case 1: 
			System.out.print("Enter the name of the item:- ");
			String name = input.next();
			System.out.println();
			System.out.print("Enter the price of the item:- ");
			double price = input.nextDouble();
			System.out.println();
			System.out.print("Enter the quantity of the item:- ");
			int quantity = input.nextInt();
			System.out.println();
			cart.addItem(name, price, quantity);
			break;
					
		case 2: 
			System.out.println("Enter the name of the item to be removed:");
			String name1 = input.next();
			cart.removeItem(name1);
			break;
					
		case 3: 
			System.out.println("Billing: ");
			cart.generateBill();
			break;
					
		case 4: break;
			
		default: System.out.println("Wrong input!! Try again!!");	
		}
	}while(choice != 4);
	}
}