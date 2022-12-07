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
	boolean isOnBoat = false;
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
		elements.get(0).add(new Car(new Position(900, 540), new Velocity (0.5,0)));

		elements.get(1).add(new Car(new Position(0, 480), new Velocity (-0.5,0)));
		elements.get(1).add(new Car(new Position(300, 480), new Velocity (-0.5,0)));
		elements.get(1).add(new Car(new Position(600, 480), new Velocity (-0.5,0)));
		elements.get(1).add(new Car(new Position(900, 540), new Velocity (0.5,0)));
		
		elements.get(2).add(new Car(new Position(0,410), new Velocity (0.5,0)));
		elements.get(2).add(new Car(new Position(300, 410), new Velocity (0.5,0)));
		elements.get(2).add(new Car(new Position(600,410), new Velocity (0.5,0)));
		elements.get(2).add(new Car(new Position(900, 540), new Velocity (0.5,0)));
		
		
		//boats
		elements.get(3).add(new Log(new Position(0,290), new Velocity (0.2,0)));
		elements.get(3).add(new Log(new Position(300, 290), new Velocity (0.2,0)));
		elements.get(3).add(new Log(new Position(600,290), new Velocity (0.2,0)));
		elements.get(3).add(new Log(new Position(900 , 290), new Velocity (0.2,0)));
		
		elements.get(4).add(new Log(new Position(0, 225), new Velocity(-0.3,0)));
		elements.get(4).add(new Log(new Position(300, 225), new Velocity(-0.3,0)));
		elements.get(4).add(new Log(new Position(600, 225), new Velocity(-0.3,0)));
		elements.get(4).add(new Log(new Position(900, 225), new Velocity(-0.3,0)));
		
		elements.get(5).add(new Log(new Position(0, 155), new Velocity (0.3,0)));
		elements.get(5).add(new Log(new Position(300, 155), new Velocity (0.3,0)));
		elements.get(5).add(new Log(new Position(600,155), new Velocity (0.3,0)));
		elements.get(5).add(new Log(new Position(900 , 155), new Velocity (0.3,0)));
		
		elements.get(6).add(new Log(new Position(0, 95), new Velocity(-0.2,0)));
		elements.get(6).add(new Log(new Position(300, 95), new Velocity(-0.2,0)));
		elements.get(6).add(new Log(new Position(600, 95), new Velocity(-0.2,0)));
		elements.get(6).add(new Log(new Position(900, 95), new Velocity(-0.2,0)));
		
		
		
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
				
		
				Element element = elements.get(i).get(j);
				double y = element.getPosition().y;
				double x = element.getPosition().x;
				double xVelo = element.getVelocity().xVelo;
				if (xVelo > 0 && x > 1000 ) {
					element.setPosition(new Position(-300, y));
				}
					else if (xVelo < 0 && element.getPosition().x + 120 < 0) { //120 is the length
						element.setPosition(new Position(1300, y));
					}
				

				if(element.type.CAR == elements.get(i).get(j).type &&
				   element.getPosition().x<= frog.getPosition().x + frog.width && frog.getPosition().x <= element.getPosition().x + element.width &&
				   element.getPosition().y<= frog.getPosition().y + frog.height && frog.getPosition().y <= element.getPosition().y + element.height) {
					
					isColliding = true;
				}
				
				if(element.type.BOAT == elements.get(i).get(j).type &&
				    element.getPosition().x<= frog.getPosition().x + frog.width && frog.getPosition().x <= element.getPosition().x + element.width &&
				    element.getPosition().y<= frog.getPosition().y + frog.height && frog.getPosition().y <= element.getPosition().y + element.height) {
				    frog.setVelocity(element.getVelocity());
		   		    isOnBoat = true;
		   		 System.out.println("onboat");
				}
				if (element.type.BOAT == elements.get(i).get(j).type && frog.getPosition().y < 306 && frog.getPosition().y <= 110 && isOnBoat != true){
					isOnBoat = false;
					System.out.println("notonboat");
				}
//				
				if(isColliding) {
					
					resetCharPosition();
					isColliding = false;
				}
				
//				System.out.println(frog.getPosition().y);
//				System.out.println(isOnBoat);
				
				if(!isOnBoat && frog.getPosition().y > 306 && frog.getPosition().y <= 110) {
					resetCharPosition();
					System.out.println("not on boat ");
					
				}
				
				
				//playerPos.x + playerWidth >= position.x && playerPos.x <= position.x + width
				
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
		 * 
		 */
		
		
		
		frog.paint(g);
		this.repaint();
	
	}
	
	
	public void resetCharPosition() {
		frog.getPosition().x = screenWidth / 2d - Frog.width/2;
		frog.getPosition().y = screenHeight - Frog.height - 40;
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
		
		this.repaint();
		

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
