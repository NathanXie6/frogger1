package Frogg;
import java.io.IOException;


public class Car extends Element{
	public static int width = 100;
	public static int height = 50;

	public Car(Position pos, Velocity velo)
			throws IOException {
		super("src/Frogg/dinosaur.png", pos, velo, velo.xVelo > 0? Direction.FACE_RIGHT : Direction.FACE_LEFT, 
				width, height, Element.Type.CAR);
		// TODO Auto-generated constructor stub
	}
}
