package connectfour;

import java.util.Random;

import connectfour.assets.Board;
import connectfour.assets.Player;
import connectfour.gui.TxtGUI;
import connectfour.strategy.HumanStrategy;

public class Game {

	// GameState constants
	private static final int NO_WINNER = -1;
	private static final int QUIT = -2;
	private static final int WINNER_PLAYER_1 = 0;
	private static final int WINNER_PLAYER_2 = 1;
	private static final int GAME_TIED = 2;
	private static final int MOVE_QUIT = -1;

	// Game variables
	private Board board;
	private int winCond;
	private int rows;
	private int cols;
	private Player[] players;
	private Random rnd = new Random();
	TxtGUI gui;

	/**
	 * Constructs a default game of connect four.<BR>
	 * Human vs. Human on a default 6 row, 7 column board<br>
	 * with 4 consecutive chips to win
	 */
	public Game() {
		this.rows = 6;
		this.cols = 7;
		board = new Board(rows, cols);
		gui = new TxtGUI(board);
		this.winCond = 4;
		players = new Player[2];
		players[0] = new Player(1, new HumanStrategy(), gui);
		players[1] = new Player(2, new HumanStrategy(), gui);
	}

	/**
	 * Constructs a new custom connect four game
	 * 
	 * @param players
	 *            Array of 2 players that play the game
	 * @param board
	 *            The Gameboard
	 * @param winCond
	 *            the winning condition
	 */
	public Game(Player[] players, Board board, int winCond) {
		this.players = players;
		this.board = board;
		gui = new TxtGUI(this.board);
		this.winCond = winCond;
		this.rows = board.getRows();
		this.cols = board.getCols();
	}

	public void init() {
		board.init();
		players[0].init();
		players[1].init();
	}

	public void run() {

		// Random player starts
		int activePlayer = rnd.nextInt(2);
		int winner = NO_WINNER;
		int move;

		// Main game loop
		do {

			// Display the board
			gui.drawBoard();

			// Query player move
			move = players[activePlayer].makeMove(players[activePlayer],
					players[1 - activePlayer], board);

			if (move != MOVE_QUIT) {
				// Execute the move on the board
				board.dropChip(activePlayer + 1, move);

				// Don't bother checking if less than 7 chips on the board
				if (board.getChipCount() >= 7) {
					
					// Check for winning conditions
					if ((board.isFull()) && (winner == NO_WINNER)) {
						winner = GAME_TIED;
					}

					if (board.checkBoard(activePlayer-1, winCond)) {
						winner = activePlayer;
					}
				}
			} else {
				winner = QUIT;
			}
			// next player
			activePlayer = 1 - activePlayer;

		} while (winner == NO_WINNER); // End main game loop

		// Draw the board one final time if the players haven't quit
		if (winner != QUIT) {
			gui.drawBoard();
		}

		switch (winner) {
		case QUIT:
			// TODO: display quit message
			break;
		case NO_WINNER:
			// Should not be reached, only here for completeness
			break;
		case WINNER_PLAYER_1:
			// TODO: Print player 1 won message
			break;
		case WINNER_PLAYER_2:
			// TODO: Print player 2 won message
			break;
		case GAME_TIED:
			// TODO: display game tied message
			break;
		default:
			// Uh-Oh something went wrong - this should never be reached
			throw new UnsupportedOperationException(
					"Illegal Game State, not supported");
		}

	}

}
