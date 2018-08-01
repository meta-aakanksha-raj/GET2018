package system;

public class Peacock extends Bird{
	
	private static int id=1;

	public Peacock(int age,double weight) {
		super("Peacock"+(id+1),age,weight,"scream",2,true,AnimalType.PEACOCK);
	}
}
