package system;

public class Bird extends Animal{
	
	private final boolean canFly;
	
	public Bird(String name,int age, double weight,String sound, int noOfLegs,boolean canFly,AnimalType type) {
		
		super(name,age,weight,sound,noOfLegs,AnimalCategory.BIRD,type);
		this.canFly=canFly;
	}

	public boolean isCanFly() {
		return canFly;
	}
	
}
