
 


public class Board implements Constants {
	private char theBoard[][];
	private int markCount;

	/**
	 * This is the default constructor for the Class Board
	 */
	public Board() {
		markCount = 0;
		theBoard = new char[3][];
		for (int i = 0; i < 3; i++) {
			theBoard[i] = new char[3];
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		}
	}

	/**
	 * This method is used to get the type of mark that is present in the row and column specified of the board
	 * @param row This parameter is used to check for the row of the board
	 * @param col This parameter is used to check for the column of the board
	 * @return char This method returns a variable of type char which is the mark in the row and column specified of the board
	 */
	public char getMark(int row, int col) {
		return theBoard[row][col];
	}

	/**
	 * This method checks to see if all the spaces in the board have been used up and returns true or false 
	 * depending on the result
	 * @return boolean The method returns true if the count of marks equals 9 and false if otherwise
	 */
	public boolean isFull() {
		return markCount == 9;
	}

	/**
	 * This method calls the checkWinner method and passes the X character to it to check if the x player has won the game.
	 * If they have won the game, the method will return true otherwise it returns false
	 * @return This will return true if the x player has won and false if they have not
	 */
	public boolean xWins() {
		if (checkWinner(LETTER_X) == 1)
			return true;
		else
			return false;
	}

	/**
	 * This method calls the checkWinner method and passes the O character to it to check if the o player has won the game.
	 * If they have won the game, the method will return true otherwise it returns false
	 * @return This will return true if the o player has won and false if they have not
	 */
	public boolean oWins() {
		if (checkWinner(LETTER_O) == 1)
			return true;
		else
			return false;
	}

	/**
	 * This method displays the board when called. It works first by calling the disPlayColumnHeaders to display the column 
	 * header at the top for the user, then it calls the addHyphens method to print the line between the column headers and the board.
	 * It then proceeds to call the addSpaces, getMark and addHyphens methods to print the board itself. 
	 */
	public void display() {
		displayColumnHeaders();
		addHyphens();
		for (int row = 0; row < 3; row++) {
			addSpaces();
			System.out.print("    row " + row + ' ');
			for (int col = 0; col < 3; col++)
				System.out.print("|  " + getMark(row, col) + "  ");
			System.out.println("|");
			addSpaces();
			addHyphens();
		}
	}

	/**
	 * This method adds a new mark to the board and increments the mark count by 1. The location and mark of the update 
	 * will depend on the parameters that are passed in.
	 * @param row This parameter determines the row that the mark will go to on the board
	 * @param col This parameter determines the column that the mark will go to on the board
	 * @param mark This parameter determines the type of mark that will go on the board 
	 */
	public void addMark(int row, int col, char mark) {
		
		theBoard[row][col] = mark;
		markCount++;
	}

	/**
	 * This method completely clears the board and replaces all the marks with spaces and resets the mark count to 0
	 */
	public void clear() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		markCount = 0;
	}

	/**
	 * This method checks if the player that possesses the mark that has been passed into the method has won the game.
	 * It does so by checking if the mark has 3 consecutive marks in all directions(whether it is up, down or diagonal). If this is true
	 * then the method will return 1, otherwise it will return 0 to indicate there is no winner so far.
	 * @param mark This parameter indicates the mark that the method will check the winner for
	 * @return This method will return 1 if there is a winner and 0 otherwise.
	 */
	int checkWinner(char mark) {
		int row, col;
		int result = 0;

		for (row = 0; result == 0 && row < 3; row++) {
			int row_result = 1;
			for (col = 0; row_result == 1 && col < 3; col++)
				if (theBoard[row][col] != mark)
					row_result = 0;
			if (row_result != 0)
				result = 1;
		}

		
		for (col = 0; result == 0 && col < 3; col++) {
			int col_result = 1;
			for (row = 0; col_result != 0 && row < 3; row++)
				if (theBoard[row][col] != mark)
					col_result = 0;
			if (col_result != 0)
				result = 1;
		}

		if (result == 0) {
			int diag1Result = 1;
			for (row = 0; diag1Result != 0 && row < 3; row++)
				if (theBoard[row][row] != mark)
					diag1Result = 0;
			if (diag1Result != 0)
				result = 1;
		}
		if (result == 0) {
			int diag2Result = 1;
			for (row = 0; diag2Result != 0 && row < 3; row++)
				if (theBoard[row][3 - 1 - row] != mark)
					diag2Result = 0;
			if (diag2Result != 0)
				result = 1;
		}
		return result;
	}

	/**
	 * This method prints the column headers out for the user whenever the display entire board method is called
	 */
	void displayColumnHeaders() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|col " + j);
		System.out.println();
	}

	/**
	 * This method prints out the hyphens to seperate the rows in the board whenever the display entire board method is called
	 */
	void addHyphens() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("+-----");
		System.out.println("+");
	}

	/**
	 * This method prints out the spaces for the board whenever the display entire board method is called
	 */
	void addSpaces() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|     ");
		System.out.println("|");
	}
}
