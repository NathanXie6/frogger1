package Frogg;

import java.io.IOException;




public class Log extends Element {
	public static int width = 120;
	public static int height = 70;

	public Log(Position pos, Velocity velo)
			throws IOException {
		super("src/Frogg/log.png", pos, velo, velo.xVelo > 0? Direction.FACE_RIGHT : Direction.FACE_LEFT, 
				width, height, Element.Type.BOAT);
		// TODO Auto-generated constructor stub
	}
	
	public void setWidth (int paramWidth) {
		width = paramWidth;
	}

}
