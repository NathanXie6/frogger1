package Frogg;

import java.io.IOException;


public class waterAnimation extends Element{
	public static int width = 1000;
	public static int height = 600;

	public waterAnimation(Position pos, Velocity velo) throws IOException {
		super("src/Frogg/waterSplash1.gif", pos, velo, velo.xVelo > 0? Direction.FACE_RIGHT : Direction.FACE_RIGHT, 
				width, height, Element.Type.BOAT);
		// TODO Auto-generated constructor stub
	}
	
	public void setWidth (int paramWidth) {
		width = paramWidth;
	}
}
