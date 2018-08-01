package system;

public class Crocodile extends Reptile {

	private static int id = 1;

	public Crocodile(int age, double weight) {
		super("Crocodile" + (id + 1), age, weight, "Grunts", 4, true,
				AnimalType.CROCODILE);
	}
}
