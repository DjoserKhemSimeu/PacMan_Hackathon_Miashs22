package PacMan;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;


public class Window extends JFrame{
	
	private Panel panel;
	private JButton buttonStart;
	private JButton buttonRestart;

	public Window() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("PAC-MAN");
		this.setSize(1000,655);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		panel = new Panel();
		panel.setBounds(0,0,616,620);
		add(panel);
		
		buttonStart = new JButton("START");
		buttonStart.setFont(new Font("START", 4, 18));
		buttonStart.setBounds(651, 420, 300, 50);
		this.add(buttonStart);
				
		buttonRestart = new JButton("RESTART");
		buttonRestart.setFont(new Font("RESTART", 4, 18));
		buttonRestart.setBounds(651, 520, 300, 50);
		this.add(buttonRestart);
		
		this.setVisible(true);
	}
	
	public JButton getButtonStart() {
		return buttonStart;
	}
	
	public JButton getButtonRestart() {
		return buttonRestart;
	}
	
	public Panel getPanel() {
		return panel;
	}

}
