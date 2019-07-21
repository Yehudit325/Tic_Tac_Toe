import java.util.Scanner; 

public class Main {

	public static void main(String[] args) {
		TTT game = new TTT(3);
		Scanner scan = new Scanner(System.in);
		int row, col; 
		game.initializeBoard();
		
		while (!game.checkForWin() && !game.isBoardFull()) {
			game.changePlayer();
			System.out.printf("Player %c please take your turn (Enter row and coloumn index)", game.getCurrentPlayer());
			game.printBoard();
			do {
				row = scan.nextInt();
				col = scan.nextInt();
			}
			while (!game.placeMark(row, col));
		}
		
		game.printBoard();
		System.out.println();
		if (game.checkForWin()) {
			System.out.println("Game over!");
			System.out.printf("Player %c won", game.getCurrentPlayer());
		} else {
			System.out.println("Game over!");
			System.out.printf("Tie game");
		}
		
		scan.close();
	}
}
