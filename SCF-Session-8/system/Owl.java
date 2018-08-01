package system;

public class Owl extends Bird{
	
	private static int id=1;

	public Owl(int age,double weight) {
		super("Owl"+(id+1),age,weight,"Hoot",2,true,AnimalType.OWL);
	}
}
