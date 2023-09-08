package PacMan;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Main {

	public static void main(String[] args) throws UnsupportedLookAndFeelException
	{
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		Window window = new Window();
		Controller controller = new Controller(window, window.getPanel());
	}
}
