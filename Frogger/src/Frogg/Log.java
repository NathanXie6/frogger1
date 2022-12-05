package Frogg;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;


public class Log extends Element {
	public static int width = 70;
	public static int height = 40;

	public Log(Position pos, Velocity velo)
			throws IOException {
		super("src/Pogger/MonkaS.png", pos, velo, velo.xVelo > 0? Direction.FACE_RIGHT : Direction.FACE_LEFT, 
				width, height, Element.Type.BOAT);
		// TODO Auto-generated constructor stub
	}
	
	public void setWidth (int paramWidth) {
		width = paramWidth;
	}

}
