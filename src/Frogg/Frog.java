package Frogg;



import java.io.IOException;

public class Frog extends Element {
	public static final int width = 50;
	public static final int height = 30;
	
	public Frog(Position pos) throws IOException {
		super("src/Frogg/turtle.png.png", pos, new Velocity(0.0,0.0), Direction.FACE_RIGHT,
				width, height, Element.Type.CHARACTER);
		// TODO Auto-generated constructor stub
	}
	
	

}
