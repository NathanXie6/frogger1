import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class FroggerMain extends JPanel implements KeyListener, ActionListener {
	
	Timer t;
	
	int screenWidth = 900;
	int screenHeight = 700;
	
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
		g.fillRect(0, 0, screenWidth, 60);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FroggerMain frogger = new FroggerMain();
	}
	
	public FroggerMain() {
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
