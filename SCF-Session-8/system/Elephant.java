package system;

public class Elephant extends Mammal{
	
	private static int id=1;
	
	public Elephant(int age,double weight) {
		super("Elephant"+(id+1), age, weight, "trumpet", 4, true,AnimalType.ELEPHANT);
	}
}
