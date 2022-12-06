package Frogg;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import Frogg.Position;
import Frogg.Element;



public class FroggerMain extends JPanel implements KeyListener, ActionListener {
	
	Timer t;
	
	int screenWidth = 900;
	int screenHeight = 700;
	boolean isOnBoat;
	boolean isColliding; 
	
	ArrayList<ArrayList<Element>> elements;
	
	Frog frog;
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FroggerMain frogger = new FroggerMain();
	}
	
	public FroggerMain() throws IOException {
		
		frog = new Frog(new Position(screenWidth / 2d - Frog.width / 2, screenHeight - Frog.height - 40));
		elements = new ArrayList<>();
		//first rows of cars
		elements.add(new ArrayList<>());
		elements.add(new ArrayList<>());
		elements.add(new ArrayList<>());
		//rows of boats
		elements.add(new ArrayList<>());
		elements.add(new ArrayList<>());
		elements.add(new ArrayList<>());
		elements.add(new ArrayList<>());
		
		//dinos
		elements.get(0).add(new Car(new Position(0, 540), new Velocity (0.5,0)));
		elements.get(0).add(new Car(new Position(300, 540), new Velocity (0.5,0)));
		elements.get(0).add(new Car(new Position(600, 540), new Velocity (0.5,0)));

		elements.get(1).add(new Car(new Position(0, 480), new Velocity (-0.5,0)));
		elements.get(1).add(new Car(new Position(220, 480), new Velocity (-0.5,0)));
		elements.get(1).add(new Car(new Position(440, 480), new Velocity (-0.5,0)));
		
		elements.get(2).add(new Car(new Position(0,410), new Velocity (0.5,0)));
		elements.get(2).add(new Car(new Position(220, 410), new Velocity (0.5,0)));
		elements.get(2).add(new Car(new Position(440,410), new Velocity (0.5,0)));
		
		
		//boats
		elements.get(3).add(new Log(new Position(0,290), new Velocity (0.5,0)));
		elements.get(3).add(new Log(new Position(220, 290), new Velocity (0.5,0)));
		elements.get(3).add(new Log(new Position(440,290), new Velocity (0.5,0)));
		elements.get(3).add(new Log(new Position(660 , 290), new Velocity (0.5,0)));
		
		elements.get(4).add(new Log(new Position(0, 225), new Velocity(-0.6,0)));
		elements.get(4).add(new Log(new Position(220, 225), new Velocity(-0.6,0)));
		elements.get(4).add(new Log(new Position(440, 225), new Velocity(-0.6,0)));
		elements.get(4).add(new Log(new Position(660, 225), new Velocity(-0.6,0)));
		
		elements.get(5).add(new Log(new Position(0, 155), new Velocity (0.6,0)));
		elements.get(5).add(new Log(new Position(220, 155), new Velocity (0.6,0)));
		elements.get(5).add(new Log(new Position(440,155), new Velocity (0.6,0)));
		elements.get(5).add(new Log(new Position(660 , 155), new Velocity (0.6,0)));
		
		elements.get(6).add(new Log(new Position(0, 95), new Velocity(-0.5,0)));
		elements.get(6).add(new Log(new Position(220, 95), new Velocity(-0.5,0)));
		elements.get(6).add(new Log(new Position(440, 95), new Velocity(-0.5,0)));
		elements.get(6).add(new Log(new Position(660, 95), new Velocity(-0.5,0)));
		
		
		
		JFrame f = new JFrame("Frogger");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		f.setSize(900,700);
		f.add(this);
		f.addKeyListener(this);
		t = new Timer(16, this);
		t.start();
		f.setVisible(true);
		
		
		
	}
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		
		
		g.setColor(Color.green);
		g.fillRect(0, 613, screenWidth, 50);
		
		//3 roads (75 each)
		g.setColor(Color.gray);
		g.fillRect(0, 388, screenWidth, 225);
		
		g.setColor(Color.green);
		g.fillRect(0, 358, screenWidth, 50);
		
		//4 layers of water (75 each)
		g.setColor(Color.BLUE);
		g.fillRect(0, 58, screenWidth, 300);
		
		g.setColor(Color.green);
		g.fillRect(0, 0, screenWidth, 80);
		
	

		for(int i = 0; i < elements.size(); i++) {
			for(int j = 0; j < elements.get(i).size(); j++) {
				
				/*
				 * SECOND
				 * 
				 * Code something here that makes it so when the logs in element
				 * gets resent back to original place when either the x value, or the x + length value
				 * crosses one of the sides
				 * 
				 * purpose is so that we can continue to reuse these logs rather than creating an infinite
				 * amount
				 * 
				 * make sure timing is okay (so the spaces don't get too small)
				 *
				 */		
				
				
				
				elements.get(i).get(j).paint(g);
			}
		}
		
		
		
		
		/*
		 * 
		 * THIRD
		 * 
		 * 
		 * implement some way to check if on boat
		 * make sure that the character follows the boat
		 * so set character velocity to the boats velocity when
		 * character is on boat
		 * 
		 * however make sure that it can't follow the boat off teh screen
		 * 
		 */
		
		
		
		frog.paint(g);
		this.repaint();
	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getKeyCode());
		if(arg0.getKeyCode() == 87) {
			frog.setPosition(new Position(frog.getPosition().x, frog.getPosition().y -65));
		}
		if(arg0.getKeyCode() == 83) {
			frog.setPosition(new Position(frog.getPosition().x, frog.getPosition().y + 65));
		}
		if(arg0.getKeyCode() == 65) {
			frog.setPosition(new Position(frog.getPosition().x - 75, frog.getPosition().y));
		}
		if(arg0.getKeyCode() == 68) {
			frog.setPosition(new Position(frog.getPosition().x + 75, frog.getPosition().y));
		}
		

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}


	
	

}
