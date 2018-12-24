

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author Leon
 *
 */
public class StartGame extends JFrame {

	private JPanel contentPane;
	private Game newGame;
	


	/**
	 * This is the main function and initiates the start of the game.
	 * @param args unused
	 */
	public static void main(String[] args) {
		StartGame game = new StartGame();
	}

	/**
	 * This method first gets the users to enter their names before
	 * calling Game's constructor to create a new Game frame.
	 */
	public StartGame() {
		String playerNameX;
		playerNameX = JOptionPane.showInputDialog("Enter your name.");
		
		String playerNameO;
		playerNameO = JOptionPane.showInputDialog("Enter your name.");
		
		newGame = new Game(playerNameX, playerNameO);
		
	}

}
