package Frogg;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import Frogg.Position;
import Frogg.Element;



public class FroggerMain extends JPanel implements KeyListener, ActionListener {
	
	Timer t;
	int points = 0;
	int count = 0;
	int lives = 7;
	int screenWidth = 900;
	int screenHeight = 700;

	boolean isOnBoat;
	boolean isColliding; 

	boolean hasScoredOn1;
	boolean hasScoredOn2;
	boolean hasScoredOn3;
	boolean hasScoredOn4;
	boolean hasScoredOn5;	

	
	ArrayList<ArrayList<Element>> elements;
	
	Frog frog;
	//stationary frogs
	Frog frog1;
	Frog frog2;
	Frog frog3;
	Frog frog4;
	Frog frog5;
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FroggerMain frogger = new FroggerMain();
	}
	
	public FroggerMain() throws IOException {
		
		frog = new Frog(new Position(screenWidth / 2d - Frog.width / 2, screenHeight - Frog.height - 45));
		frog1 = new Frog(new Position(105,40));
		frog2 = new Frog(new Position(265, 40));
		frog3 = new Frog(new Position(425, 40));
		frog4 = new Frog(new Position(585, 40));
		frog5 = new Frog(new Position(745, 40));
		
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
		elements.get(0).add(new Car(new Position(0, 540), new Velocity (0.4,0)));
		elements.get(0).add(new Car(new Position(300, 540), new Velocity (0.4,0)));
		elements.get(0).add(new Car(new Position(600, 540), new Velocity (0.4,0)));
		elements.get(0).add(new Car(new Position(900, 540), new Velocity (0.4,0)));

		elements.get(1).add(new Car(new Position(0, 480), new Velocity (-0.5,0)));
		elements.get(1).add(new Car(new Position(300, 480), new Velocity (-0.5,0)));
		elements.get(1).add(new Car(new Position(600, 480), new Velocity (-0.5,0)));
		elements.get(1).add(new Car(new Position(900, 480), new Velocity (-0.5,0)));
		
		elements.get(2).add(new Car(new Position(0,410), new Velocity (0.3,0)));
		elements.get(2).add(new Car(new Position(300, 410), new Velocity (0.3,0)));
		elements.get(2).add(new Car(new Position(600,410), new Velocity (0.3,0)));
		elements.get(2).add(new Car(new Position(900, 410), new Velocity (0.3,0)));
		
		
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
		
		//grass
		g.setColor(new Color(43, 171, 26));
		g.fillRect(0, 613, screenWidth, 50);
		
		g.setColor(Color.black);
		
		//3 roads (75 each)
		g.setColor(new Color(40,40,40));
		g.fillRect(0, 388, screenWidth, 225);
		
		//grass
		g.setColor(new Color(43, 171, 26));
		g.fillRect(0, 358, screenWidth, 50);
		
		//4 layers of water (75 each)
		g.setColor(new Color(20, 65, 168));
		g.fillRect(0, 58, screenWidth, 300);
		
		//grass
		g.setColor(new Color(43, 171, 26));
		g.fillRect(0, 0, screenWidth, 80);
		
		
		g.setColor(new Color(30, 105, 20));
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(4));
		g2.drawLine(0, 613, 900, 613);
		g2.drawLine(0, 408, 900, 408);
		g2.drawLine(0, 358, 900, 358);
		g2.drawLine(0, 82, 900, 82);
		
		//goal
		g.setColor(new Color(20, 65, 168));
		g.fillRect(105, 40, 50, 50);
		g.fillRect(265, 40, 50, 50);
		g.fillRect(425, 40, 50, 50);
		g.fillRect(585, 40, 50, 50);
		g.fillRect(745, 40, 50, 50);
	
		
		
		g.setColor(Color.black);
		Font font2 = new Font("Arcade Classic", Font.BOLD,40);
		g.setFont(font2);
		g.drawString("Lives Left: " + lives, 10, 650);
		
		Font scoreFont = new Font("Arcade Classic", Font.BOLD, 15);
		g.setFont(scoreFont);
		g.drawString("Score: " + points, 400, 20);

			isOnBoat = false;
			
			for(int i = 0; i < elements.size(); i++) {
				for(int j = 0; j < elements.get(i).size(); j++) {
					
			
					Element element = elements.get(i).get(j);
					double y = element.getPosition().y;
					double x = element.getPosition().x;
					double xVelo = element.getVelocity().xVelo;
					
					
					elements.get(i).get(j).paint(g);
					
					if (xVelo > 0 && x > 1000 ) {
						element.setPosition(new Position(-300, y));
					}
						else if (xVelo < 0 && element.getPosition().x + 120 < 0) { //120 is the length of element
							element.setPosition(new Position(1300, y));
						}
			
					

					if(element.type.CAR == elements.get(i).get(j).type &&
					   element.getPosition().x <= frog.getPosition().x + frog.width && frog.getPosition().x <= element.getPosition().x + element.width &&
					   element.getPosition().y <= frog.getPosition().y + frog.height && frog.getPosition().y <= element.getPosition().y + element.height) {
						
						isColliding = true;

			
					}
					
					
					else if(element.type.BOAT == elements.get(i).get(j).type &&
					    element.getPosition().x <= frog.getPosition().x + frog.width && frog.getPosition().x <= element.getPosition().x + element.width &&
					    element.getPosition().y <= frog.getPosition().y + frog.height && frog.getPosition().y <= element.getPosition().y + element.height) {
					    frog.setVelocity(element.getVelocity());
					    
					    if( frog.getPosition().x > 900-frog.width || frog.getPosition().x < 0) {
					    	frog.setVelocity(new Velocity(0,0));
					    }
			   		    isOnBoat = true;
					} 
				
					if(isColliding) {
						resetCharPosition();
						if(lives > 0) {
							lives--;
							points-=10;
						}
						isColliding = false;
					}
				}
			}
			
			if(frog.getPosition().x < 0) {
				frog.setPosition(new Position(0, (int)frog.getPosition().y));
			}else if(frog.getPosition().x > 790 + frog.width) {
				frog.setPosition(new Position(790 + frog.width , (int)frog.getPosition().y));
			}
			if(frog.getPosition().y > 700 - frog.height) {
				frog.setPosition(new Position(frog.getPosition().x, 700));
			} else if(frog.getPosition().y < 0) {
				frog.setPosition(new Position(frog.getPosition().x, 0));
			}
			
			if(!isOnBoat && frog.getPosition().y <= 306 && frog.getPosition().y >= 100) {
				lives--;
				resetCharPosition();
			}
			
			
			/*
			 * 
				g.fillRect(105, 40, 50, 50);
				g.fillRect(265, 40, 50, 50);
				g.fillRect(425, 40, 50, 50);
				g.fillRect(585, 40, 50, 50);
				g.fillRect(745, 40, 50, 50);
			 */
			

			if(frog.getPosition().x >= 100 && frog.getPosition().x <= 160 && frog.getPosition().y < 90 && frog.getPosition().y > 10) {
				frog1.paint(g);
				hasScoredOn1 = true;
				if(lives > 0) {
					points += 50;
				}
				resetCharPosition();
			}	
			
			if(frog.getPosition().x >= 260 && frog.getPosition().x <= 320 && frog.getPosition().y < 90 && frog.getPosition().y > 10) {
				frog2.paint(g);
				hasScoredOn2 = true;
				resetCharPosition();
				if(lives > 0) {
					points += 50;
				}
			}
			
			if(frog.getPosition().x >= 420 && frog.getPosition().x <= 480 && frog.getPosition().y < 90 && frog.getPosition().y > 10) {
				frog3.paint(g);
				hasScoredOn3 = true;
				resetCharPosition();
				if(lives > 0) {
					points += 50;
				}
			}
			
			if(frog.getPosition().x >= 580 && frog.getPosition().x <= 640 && frog.getPosition().y < 90 && frog.getPosition().y > 10) {
				frog4.paint(g);
				hasScoredOn4 = true;
				resetCharPosition();
				if(lives > 0) {
					points += 50;
				}
			}
			
			if(frog.getPosition().x >= 740 && frog.getPosition().x <= 800 && frog.getPosition().y <90 && frog.getPosition().y > 10) {
				frog5.paint(g);
				hasScoredOn5 = true;
				resetCharPosition();
				if(lives > 0) {
					points += 50;
				}
			}
			
			if(hasScoredOn1) {
				frog1.paint(g);

			}
			
			if(hasScoredOn2) {
				frog2.paint(g);

			}
			
			if(hasScoredOn3) {
				frog3.paint(g);

			}
			
			if(hasScoredOn4) {
				frog4.paint(g);

			}
			
			if(hasScoredOn5) {
				frog5.paint(g);
	
			}
			
			if(hasScoredOn1 && hasScoredOn2 && hasScoredOn3 && hasScoredOn4 && hasScoredOn5) {
				resetTurtleScored();
				points += 1000;
			}
			
			if(lives <= 0) {
				g.setColor(Color.WHITE);
				Font GameOver = new Font("Impact", Font.PLAIN, 100);
				g.setFont(GameOver);
				g.drawString("Game Over", 210, 250);
	

				g.drawString("Score: " + String.valueOf(points), 225, 400);
				
				resetCharPosition();
			}
			
			

	

//Add a timer bar
		
		
		
		frog.paint(g);
		this.repaint();
	
	}
	
	public void resetTurtleScored() {
		hasScoredOn5 = false;
		hasScoredOn4 = false;
		hasScoredOn3 = false;
		hasScoredOn2 = false;
		hasScoredOn1 = false;
	}

	
	
	
	public void resetCharPosition() {
		frog.getPosition().x = screenWidth / 2d - Frog.width/2;
		frog.getPosition().y = screenHeight - Frog.height - 45;
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
//		System.out.println(arg0.getKeyCode());
		if(arg0.getKeyCode() == 87) {
			frog.setPosition(new Position(frog.getPosition().x, frog.getPosition().y -65));
			frog.setVelocity(new Velocity (0,0));
			if(lives > 0) {
				points += 10;
			}
		}
		if(frog.getPosition().y < screenHeight-80) {
			if(arg0.getKeyCode() == 83) {
				frog.setPosition(new Position(frog.getPosition().x, frog.getPosition().y + 65));
				frog.setVelocity(new Velocity (0,0));
			}
		}
		if(arg0.getKeyCode() == 65) {
			frog.setPosition(new Position(frog.getPosition().x - 55, frog.getPosition().y));
			frog.setVelocity(new Velocity (0,0));
		}
		if(arg0.getKeyCode() == 68) {
			frog.setPosition(new Position(frog.getPosition().x + 55, frog.getPosition().y));
			frog.setVelocity(new Velocity (0,0));
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
