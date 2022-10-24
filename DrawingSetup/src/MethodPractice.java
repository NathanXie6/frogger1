import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MethodPractice extends JPanel{
	
	// Practice calling methods with parameters
	// by drawing the required shapes/patterns from the document
	public void paint(Graphics g) {
//		g.drawOval(200, 200, 200, 200);
//		g.fillRect(0, 0, 50, 50);
//		
//		g.drawLine(0, 300, 600, 300);
//		g.drawLine(300, 0, 300, 600);
		
		//APCS Letters
//		g.fillRect(30, 30, 25, 115); //A
//		g.fillRect(90, 30, 25, 115);
//		g.fillRect(30, 30, 60, 25);
//		g.fillRect(30, 80, 60, 25);
//		
//		g.fillRect(130, 30, 25, 115); //P
//		g.fillRect(130, 30, 85, 25);
//		g.fillRect(130, 80, 85, 25);
//		g.fillRect(190, 30, 25, 75);
//		
//		g.fillRect(230, 30, 25, 115); //C
//		g.fillRect(230, 30, 70, 25);
//		g.fillRect(230, 120, 70, 25);
//		
//		g.fillRect(330, 30, 25, 50);//S
//		g.fillRect(330, 30, 80, 25);
//		g.fillRect(330, 75, 80, 25);
//		g.fillRect(385, 85, 25, 57);
//		g.fillRect(330, 120, 80, 25);
//		
//		//Cube      side length = 150     diagonal goes up 50, left 70
//		//Front Face
//		g.drawRect(700, 150, 150, 150);
//		//Side Face (left)
//		g.drawLine(700, 150, 630, 100);
//		g.drawLine(630, 100, 630, 250);
//		g.drawLine(630, 250, 700, 300);
//		//Side Face (top)
//		g.drawLine(850, 150, 780, 100);
//		g.drawLine(780, 100, 630, 100);
//		//Side Face (back)
//		g.drawLine(780, 100, 780, 250);
//		g.drawLine(780, 250, 630, 250);
//		//Side Face (right)
//		g.drawLine(780, 250, 850, 300);
//		
//		
//		//Sphere
//		//Vert ovals
//		g.drawOval(200, 300, 200, 200);
//		g.drawOval(225, 300, 150, 200);
//		g.drawOval(250, 300, 100, 200);
//		g.drawOval(275, 300, 50, 200);
//		
//		//Horz ovals
//		g.drawOval(200, 325, 200, 145);
//		g.drawOval(200, 350, 200, 95);
//		g.drawOval(200, 375, 200, 40);
//		
//		
//		//Circle
//		g.drawOval(600, 450, 200, 200);
//		//Triangle
//		g.drawLine(600, 550, 780, 490);
//		g.drawLine(780, 490, 700, 650);
//		g.drawLine(700, 650, 600, 550);
//		//inner circle
//		g.drawOval(641, 523, 94, 94);
//		
//		
//		//Pacmen Flower
//		//left pacman
//		g.fillArc(290, 700, 100, 100, -45, 180);
//		g.fillArc(290, 700, 100, 100, 45, -180);
//		//top pacman
//		g.fillArc(360, 640, 100, 100, -230, 180);
//		g.fillArc(360, 640, 100, 100, 230, 180);
//		//right pacman
//		g.fillArc(430, 700, 100, 100, 45, 180);
//		g.fillArc(430, 700, 100, 100, -45, -180);
//		//bottom pacman
//		g.fillArc(360, 760, 100, 100, 230, -180);
//		g.fillArc(360, 760, 100, 100, -230, -180);
		
		g.setColor(color);
		g.fillOval(100, 100, 150, 150);
		
		g.setColor(color2);
		g.fillOval(135, 120, 35, 35);
		g.fillOval(185, 120, 35, 35);
		g.fillArc(133, 175, 85, 50, 0, -180);
		
		
		g.setColor(color.WHITE);
		g.fillOval(135, 122, 20, 20);
		g.fillOval(185, 122, 20, 20);
		
	//Methods!!
	/* 
	 * 
	 * name(parameters)
	 * parameters - data for the method
	 * 
	 */
		
		
		
	}
	
	private Color color = Color.YELLOW;
	private Color color2 = Color.BLACK;
	
	
	
	public static void main(String[] arg) {
		
		MethodPractice m = new MethodPractice();
		int x = -1;
		//Math class is used for some of the less basic math functions
		x = Math.abs(x);
		
		System.out.println(Math.abs(Math.sqrt(44)-190));
		
		
//		System.out.println((int)(Math.random()*6) +1);
		
		//(int)(Math.random()* (range+1) ) + min; generates a random number
		int high = 7;
		int low = 3;
		int range = high - low;
		
		int val = ((int)(Math.random() * (range + 1)) + low);
		System.out.println(val);
	}
	
	public MethodPractice() {
		JFrame f = new JFrame("Method Use");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1000,1000);
		f.add(this);
		f.setVisible(true);
		
	}
}
