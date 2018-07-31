package shopping;

import java.util.ArrayList;
import java.util.List;

/**
 * To create a product or an item
 */
class Item{
	private int id;
	private double price;
	private int quantity;

	/**
	 * This is constructor to initialize the values of item
	 * @param id is the product id 
	 * @param price
	 * @param quantity
	 */
	public Item(int id,double price, int quantity){
		this.id = id;
		this.price = price;
		this.quantity = quantity;
	}
	
	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
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
		System.out.println(id+"\t\t\t"+price+"\t\t"+quantity+"\t\t"+total());
	}
}

/**
 * It has methods to add, remove and generate bill
 */
class ShoppingCart{
	List<Item> items = new ArrayList<Item>();
	Promotion promotion;

	/**
	 * Adds particular item to cart if it is already added then increase its quantity only
	 * @param id
	 * @param price
	 * @param quantity
	 */
	public void addItem(int id, double price, int quantity){
		boolean update = false;
		for(Item item : items){
			if(item.getId()==(id)){
				update = true;
				int q = item.getQuantity();
				item.setQuantity(quantity + q);
				break;
			}
		}
		if(update == false){
		Item item = new Item(id, price, quantity);
		items.add(item);
		}
		System.out.println("Item is added to the Cart");
	}

	/**
	 * Remove particular item from the cart
	 * @param id
	 */
	public void removeItem(int id){
		for(Item item:items){
			if(id==(item.getId())){
				items.remove(item);
				break;
			}
		}
		System.out.println("Item is removed from the Cart");
	}

	/**
	 * To generate bill, if promocode is applicable then discount is applied
	 * @param promocode
	 */
	public void generateBill(String promocode){
		double sum=0;
		System.out.println("id\t\t\tprice\t\tquantity\ttotal");
		for(Item i:items){
			i.showItem();
			sum += i.total();
		}
		System.out.println();
		promotion=new FixedOrderPromotion();
		promotion.setMinimumPrice(1000);
		promotion.setFixedDiscount(50);
		double discount=applyPromotion(promotion,promocode,sum);
		System.out.println("\n Grand Total:  " + (sum - (discount/100)*sum));
	}

	/**
	 * this checks promocode and amount both then discount is applied
	 * @param promotion
	 * @param code
	 * @param amount
	 * @return discount
	 */
	public double applyPromotion(Promotion promotion, String code, double amount) {
		double discount = 0;
		if(promotion.isPromotionApplicable(code) && amount >= promotion.getMinimumPrice()) {
			discount = promotion.getFixedDiscount();
		}
		return discount;
	}
}