package system;

public class Reptile extends Animal{
	
	private final boolean isColdBlood;
	
	public Reptile(String name,int age, double weight,String sound, int noOfLegs,boolean isColdBlood,AnimalType type) {
		
		super(name,age,weight,sound,noOfLegs,AnimalCategory.REPTILE,type);
		this.isColdBlood=isColdBlood;
	}

	public boolean isColdBlood() {
		return isColdBlood;
	}
	

}
