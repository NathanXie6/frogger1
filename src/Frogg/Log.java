package Frogg;

import java.io.IOException;




public class Log extends Element {
//	public static int width = 150;
	public static int width = (int) (Math.random()*151 + 75);
	public static int height = 40;

	public Log(Position pos, Velocity velo)
			throws IOException {
		super("src/Frogg/log.png", pos, velo, velo.xVelo > 0? Direction.FACE_RIGHT : Direction.FACE_RIGHT, 
				width, height, Element.Type.BOAT);
		// TODO Auto-generated constructor stub
	}
	
	public void setWidth (int paramWidth) {
		width = paramWidth;
	}

}
