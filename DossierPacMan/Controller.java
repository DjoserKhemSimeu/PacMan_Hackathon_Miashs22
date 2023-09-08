package PacMan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller{

	private Window window;
	private Panel panel;
	
	public Controller(Window window, Panel panel) {
		this.window = window;
		this.panel = panel;

		initializeListener();
	}
	
	public void initializeListener() {
		window.getButtonStart().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.getTimer().start();
				panel.requestFocus(true);
			}
		});
		
		window.getButtonRestart().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
	}
	
	public void updateDirectionPacMan() {
		int dir = panel.getDirection();
		panel.getPac().changementDirection(dir);
	}

	
	
}
