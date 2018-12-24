

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Game extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextArea textField_2;
	private JButton btnNewButton_8;
	private Board backendBoard;
	private static int moveCount = 0;
	

	/**
	 * This is the constructor for class Game and creates a new instance of class Board
	 * to keep track of what spaces are marked from user input. The class then creates the GUI for both users
	 * to play the game. 
	 * @param playerNameX This is the parameter passed in from class StartGame and contains the player name for X
	 * @param playerNameO This is the parameter passed in from class StartGame and contains the player name for O
	 */
	public Game(String playerNameX, String playerNameO) {
		backendBoard = new Board();
		
		setTitle("Tic-Tac-Toe Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Player:");
		lblNewLabel.setBounds(266, 22, 41, 16);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(319, 17, 31, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText("X");
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(266, 50, 61, 16);
		contentPane.add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(319, 45, 158, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(playerNameX);
		
		JLabel lblMessageWindow = new JLabel("Message Window:");
		lblMessageWindow.setBounds(266, 83, 124, 16);
		contentPane.add(lblMessageWindow);
		
		
		textField_2 = new JTextArea();
		textField_2.setEditable(false);
		textField_2.setLineWrap(true);
		textField_2.setWrapStyleWord(true);
		textField_2.setBounds(266, 99, 211, 182);
		contentPane.add(textField_2);
		textField_2.setColumns(100);
		textField_2.setText(playerNameX + ", it is your turn.");
		
		
		JPanel panel = new JPanel();
		panel.setBounds(19, 22, 225, 259);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check(btnNewButton_3,0,2,playerNameX,playerNameO);
			}
		});
		
		JButton btnNewButton_1 = new JButton("");
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check(btnNewButton_1,0,0,playerNameX,playerNameO);
			}
		});
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check(btnNewButton_2,0,1,playerNameX,playerNameO);
			}
		});
		panel.add(btnNewButton_2);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check(btnNewButton,2,2,playerNameX,playerNameO);
			}
		});
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check(btnNewButton_4,1,0,playerNameX,playerNameO);
			}
		});
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check(btnNewButton_5,1,1,playerNameX,playerNameO);
			}
		});
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check(btnNewButton_6,1,2,playerNameX,playerNameO);
			}
		});
		panel.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check(btnNewButton_7,2,0,playerNameX,playerNameO);
			}
		});
		panel.add(btnNewButton_7);
		
		btnNewButton_8 = new JButton("");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check(btnNewButton_8,2,1,playerNameX,playerNameO);

			}
		});
		panel.add(btnNewButton_8);
		panel.add(btnNewButton);
				
		
		setVisible(true);
	}
	
	/**
	 * The method check is invoked every time a button has been pressed by the user to determine what should be
	 * displayed by the GUI  
	 * @param button This parameter is used to alter the button following checks done by the method
	 * @param row This parameter corresponds to the row number that was clicked on from the GUI
	 * @param col This parameter corresponds to the column number that was clicked on from the GUI
	 * @param playerNameX This parameter contains the player name for X
	 * @param playerNameO This parameter contains the player name for O
	 */
	public void check(JButton button, int row, int col, String playerNameX, String playerNameO) {
	
		if (button.getText() == "") {
			if (moveCount % 2 == 0) {
				textField.setText("O");
				textField_1.setText(playerNameO);
				button.setText("X");
				backendBoard.addMark(row,col,'X');
				if (backendBoard.xWins()) {
					textField_2.setText("THE GAME IS OVER: " + playerNameX + " has won!");
					setEnabled(false);
				}
				else if (backendBoard.isFull()) {
					textField_2.setText("THE GAME HAS ENDED... No winner.");
					setEnabled(false);
				}
				else {
					textField_2.setText(playerNameO + ", it is your turn.");
				}
				moveCount++;
			}
			else {
				textField.setText("X");
				textField_1.setText(playerNameX);
				button.setText("O");
				backendBoard.addMark(row, col,'O');
				if (backendBoard.oWins()) {
					textField_2.setText("THE GAME IS OVER: " + playerNameO + " has won!");
					setEnabled(false);
				}
				else if (backendBoard.isFull()) {
					textField_2.setText("THE GAME HAS ENDED... No winner.");
					setEnabled(false);
				}
				else {
					textField_2.setText(playerNameX + ", it is your turn.");
				}
				moveCount++;
			}
		}
		else {
			textField_2.setText("Sorry, this spot has already been taken. Try again.");
		}
		
	}

}
