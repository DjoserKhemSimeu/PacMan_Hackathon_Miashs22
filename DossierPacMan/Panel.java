package PacMan;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends Grille implements ActionListener, KeyListener{
	
	private static final int WIDTH = 616;
	private static final int HEIGHT = 620;
	private static final int ECART = 4;

	private Timer timer = new Timer(20, this);
	
	private int direction=4;
	
	public Panel() {
		super();
		this.setSize(WIDTH, HEIGHT);
		this.setBackground(Color.BLACK);
		this.setFocusable(true);
		addKeyListener(this);
		requestFocus();
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D graph = (Graphics2D) g;
		updatePanel(graph);
		
	}
	
	public void updatePanel(Graphics2D g) {
		drawWall(g);
		pM.drawPac(g);
	}
	
	public void checkCollision() {
		int absPacMan = pixelToCase(pM.getPosX());
		int ordPacMan = pixelToCase(pM.getPosY());
		

		//1ere ligne :
		
		//if (pM.getPosX())
		
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		pM.move(direction);
		checkCollision();
		repaint();
	}
	
	public Timer getTimer() {
		return timer;
	}
	
	public Pac getPac() {
		return pM;
	}
	
	public void drawWall(Graphics2D g) {
		
		g.setColor(Color.BLUE);
		g.setStroke(new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		
		int[] tabX_1 = {0,6*22,6*22, 22, 22, 13*22, 13*22, 15*22, 15*22, 27*22, 27*22, 22*22, 22*22, 29*22,
				29*22, 23*22, 23*22, 28*22-2, 28*22-2, 2,2, 5*22, 5*22, -2,-2};
		int[] tabY_1 = {14*22, 14*22, 9*22, 9*22, 22, 22, 5*22, 5*22, 22, 22, 9*22, 9*22, 14*22, 14*22,
				13*22, 13*22, 10*22, 10*22, 2, 2, 10*22, 10*22, 13*22, 13*22, 14*22};
		g.drawPolygon(tabX_1, tabY_1, 25);
		
		
		int[] tabX_2 = {7*22+ECART, 9*22-ECART, 9*22-ECART, 12*22-ECART, 12*22-ECART, 9*22-ECART, 9*22-ECART, 7*22+ECART, 7*22+ECART};
		int[] tabY_2 = {6*22+ECART, 6*22+ECART, 9*22+ECART, 9*22+ECART, 11*22-ECART, 11*22-ECART, 14*22-ECART, 14*22-ECART, 6*22+ECART};
		g.drawPolygon(tabX_2, tabY_2, tabX_2.length);
		
		
		int[] tabX_3 = {10*22, 18*22, 18*22, 15*22, 15*22, 13*22, 13*22, 10*22, 10*22};
		int[] tabY_3 = {6*22, 6*22, 8*22, 8*22, 11*22, 11*22, 8*22, 8*22, 6*22};
		g.drawPolygon(tabX_3, tabY_3, tabX_3.length);

		
		int[] tabX_4 = {19*22, 21*22, 21*22, 19*22, 19*22, 16*22, 16*22, 19*22, 19*22};
		int[] tabY_4 = {6*22, 6*22, 14*22, 14*22, 11*22, 11*22, 9*22, 9*22, 6*22};
		g.drawPolygon(tabX_4, tabY_4, tabX_4.length);
		
		
		int[] tabX_5 = {10*22, 18*22, 18*22, 15*22, 15*22, 13*22, 13*22, 10*22, 10*22};
		int[] tabY_5 = {18*22, 18*22, 20*22, 20*22, 23*22, 23*22, 20*22, 20*22, 18*22};
		g.drawPolygon(tabX_5, tabY_5, tabX_5.length);
		
		
		int[] tabX_6 = {2*22, 6*22, 6*22, 4*22, 4*22, 2*22, 2*22};
		int[] tabY_6 = {21*22, 21*22, 26*22, 26*22, 23*22, 23*22, 21*22};
		g.drawPolygon(tabX_6, tabY_6, tabY_6.length);
		
		
		int[] tabX_7 = {22*22, 26*22, 26*22, 24*22, 24*22, 22*22, 22*22};
		int[] tabY_7 = {21*22, 21*22, 23*22, 23*22, 26*22, 26*22, 21*22};
		g.drawPolygon(tabX_7, tabY_7, tabY_7.length);
		
		int[] tabX_8 = {-2, 6*22, 6*22, 22, 22, 3*22, 3*22, 22, 22, 27*22, 27*22, 25*22, 25*22, 27*22, 27*22, 22*22, 22*22, 
				29*22, 29*22, 23*22, 23*22, 28*22-2, 28*22-2, 2, 2, 5*22, 5*22, -2};
		int[] tabY_8 = {16*22, 16*22, 20*22, 20*22, 24*22, 24*22, 26*22, 26*22, 27*22, 27*22, 26*22, 26*22, 24*22, 24*22, 20*22, 
				20*22, 16*22, 16*22, 17*22, 17*22, 19*22, 19*22, 28*22, 28*22, 19*22, 19*22, 17*22, 17*22, 16*22};
		g.drawPolygon(tabX_8, tabY_8, tabX_8.length);
		
		g.drawRect(10*22, 12*22, 8*22, 5*22);
		
		g.drawRect(11*22, 13*22, 6*22, 3*22);
		
		g.drawRect(2*22, 2*22, 4*22, 3*22);
		
		g.drawRect(7*22, 2*22, 5*22, 3*22);
		
		g.drawRect(2*22, 6*22, 4*22, 2*22);
		
		g.drawRect(16*22, 2*22, 5*22, 3*22);
		
		g.drawRect(22*22, 2*22, 4*22, 3*22);
		
		g.drawRect(22*22, 6*22, 4*22, 2*22);
		
		g.drawRect(7*22, 16*22, 2*22, 4*22);
		
		g.drawRect(19*22, 16*22, 2*22, 4*22);
		
		g.drawRect(7*22, 21*22, 5*22, 2*22);
		
		g.drawRect(16*22, 21*22, 5*22, 2*22);
		
		g.drawRect(7*22, 24*22, 14*22, 2*22);
		

	}
	
	
	public int getDirection() {
		return direction;
	}
	

	@Override
	public void keyPressed(KeyEvent e) {
		

		switch(e.getKeyChar()) {
		case 's':
			direction = 2;
			break;
	
		case 'q':
			direction = 3;
			break;
	
		
		case 'z':
			direction = 0;
			break;
		
		case 'd':
			direction = 1;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

		
}



 