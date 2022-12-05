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



public class FroggerMain extends JPanel implements KeyListener, ActionListener {
	
	Timer t;
	
	int screenWidth = 900;
	int screenHeight = 700;
	boolean isOnBoat;
	boolean isColliding; 
	
	ArrayList<ArrayList<Element>> elements;
	
	Frog frog;
	
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		
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
		
		elements.get(0).add(new Log(new Position(0,538), new Velocity (1,0)));
		
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
		g.fillRect(0, 0, screenWidth, 60);
		

		frog.paint(g);
		this.repaint();
	
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FroggerMain frogger = new FroggerMain();
	}
	
	public FroggerMain() throws IOException {
		
		frog = new Frog(new Position(screenWidth / 2d - Frog.width / 2, screenHeight - Frog.height - 40));
		
		JFrame f = new JFrame("Frogger");
		//makes sure that the program stops when the window is close
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //don't delete
		
		//GUI dimensions - width - height
		f.setSize(900,700);
		
		
		f.add(this);
		f.addKeyListener(this);
		t = new Timer(16, this);
		t.start();
		f.setVisible(true);
		
		
		
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
			frog.setPosition(new Position(frog.getPosition().x, frog.getPosition().y -75));
		}
		if(arg0.getKeyCode() == 83) {
			frog.setPosition(new Position(frog.getPosition().x, frog.getPosition().y + 75));
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
