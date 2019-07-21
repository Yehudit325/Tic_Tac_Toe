import java.util.Collections;

/*
 * Tic Tac Toe Game
 * Designed for any size of board
 */
public class TTT {
	private char[][] board;
	private char currentPlayerMark;
	private int boardSize;

	public TTT(int n) {
		/*
		 * This is the constructor. It will be responsible for ensuring the board gets
		 * initialized properly, and for setting who the first player will be.
		 */
		boardSize = n;
		board = new char[n][n];
		currentPlayerMark = 'o';
	}
	
	public char getCurrentPlayer() {
		return currentPlayerMark;
	}

	public void initializeBoard() {
		// This method will initialize the board variable such that all slots are empty.
		for (int i = 0; i < boardSize; ++i) {
			for (int j = 0; j < boardSize; ++j) {
				board[i][j] = ' ';
			}
		}
	}

	public void printBoard() {
		// This method will print the Tic-Tac-Toe board to standard output.
		for (int i = 0; i < boardSize; ++i) {
			System.out.println();
			for (int j = 0; j < boardSize; ++j) {
				System.out.print(" ");
				System.out.print(board[i][j]);
				if (j != boardSize -1) {
					System.out.print(" |");
				}
			}
			System.out.println();
			if (i != boardSize -1) {
				int n = 3*boardSize + boardSize - 1;
				System.out.print(String.join("", Collections.nCopies(n, "-")));
			}
		}
	}

	public boolean isBoardFull() {
		for (int i = 0; i < boardSize; ++i) {
			for (int j = 0; j < boardSize; ++j) {
				if (board[i][j] == ' ')
					return false;
			}
		}
		return true; 
	}

	public boolean checkForWin() {
		// This method will check to see if a player has won, and if so, it will return true.
		return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());
	}

	private boolean checkRowsForWin() {
		// This method will specifically check the rows for a win.
		for (int i = 0; i < boardSize; ++i) {
			for (int j = 0; j < boardSize; ++j) {
				if (board[i][j] != currentPlayerMark) {
					break;
				} else if (j == boardSize - 1) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean checkColumnsForWin() {
		// This method will specifically check the columns for a win.
		for (int i = 0; i < boardSize; ++i) {
			for (int j = 0; j < boardSize; ++j) {
				if (board[j][i] != currentPlayerMark) {
					break;
				} else if (j == boardSize - 1) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean checkDiagonalsForWin() {
		// This method will specifically check the diagonals for a win.
		int i = 0;
		for (int j = 0; j < boardSize; ++j, ++i) {
			if (board[i][j] != currentPlayerMark) {
				break;
			} else if (j == boardSize - 1) {
				return true;
			}
		}
		
		i = boardSize - 1;
		for (int j = 0; j < boardSize; ++j, --i) {
			if (board[i][j] != currentPlayerMark) {
				break;
			} else if (j == boardSize - 1) {
				return true;
			}
		}
		
		return false;
	}

	public void changePlayer() {
		//The changePlayer() method will swap the variable currentPlayerMark between x and o.
		if (currentPlayerMark == 'x') {
			currentPlayerMark = 'o';
		} else {
			currentPlayerMark = 'x';
		}
	}

	public boolean placeMark(int row, int col) {
		if (row >=0 && row < boardSize) {
			if (col >= 0 && col < boardSize) {
				if (board[row][col] == ' ') {
					board[row][col] = currentPlayerMark;
					return true;
				}
			}
		}
		System.out.println("Invalid input, please try again");
		return false;
	}

}
