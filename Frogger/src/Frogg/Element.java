package Frogg;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Element {
	public enum Direction {
		FACE_LEFT, FACE_RIGHT
	}
	public enum Type{
		CAR, BOAT, CHARACTER
	}
	
	private BufferedImage image;
	private Direction direction;
	
	private Velocity velocity;
	private Position position;
	public final int width;
	public final int height;
	
	public final Type type;
	

	
	public Element(String imagePath, Position pos,Velocity velo, 
			Direction direction, int width, int height, Type type) 
			throws IOException{
		image = ImageIO.read(new File(imagePath));
		image = resizeImage(image, direction, width, height);
				
		this.direction = direction;
		
		position = pos;
		velocity = velo;
		this.width = width;
		this.height = height;
		this.type = type;
		}
	
	
	
	public static BufferedImage resizeImage(BufferedImage image, Direction direction, int width, int height) {
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = img.createGraphics();
		g.drawImage(image, 0, 0, width, height, null);
		g.dispose();

		if (direction == Direction.FACE_LEFT) {
			AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
			tx.translate(-img.getWidth(null), 0);
			AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
			img = op.filter(img, null);
		}

		return img;
	}
	
	public void setPosition(Position pos) {
		position = pos;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public Velocity getVelocity() {
		return velocity;
	}
	
	public void setVelocity(Velocity velo) {
		velocity = velo;
	}
	
	
	
	public void paint(Graphics g) {
		g.drawImage(image,(int)Math.round(position.x), (int)Math.round(position.y), null);
		
	}
	




	

}
