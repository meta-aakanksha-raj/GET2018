package system;

public class Lion extends Mammal{
	private static int id = 1;

	Lion(int age, double weight) {
		super("Lion"+(id+1), age, weight, "Roar", 4,true,AnimalType.LION);
	}
}
