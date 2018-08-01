package system;

public class Mammal extends Animal{
	
	private final boolean haveFur;
	
	public Mammal(String name,int age, double weight,String sound, int noOfLegs,boolean haveFur,AnimalType type) {
		
		super(name,age,weight,sound,noOfLegs,AnimalCategory.MAMMAL,type);
		this.haveFur=haveFur;
	}

	public boolean haveFur() {
		return haveFur;
	}
	
}
