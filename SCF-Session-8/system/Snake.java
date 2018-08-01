package system;

public class Snake extends Reptile{
	
	private static int id=1;

	public Snake(int age,double weight) {
		super("Snake"+(id+1),age,weight,"Hiss",4,true,AnimalType.SNAKE);
	}

}
