package connectfour;

import connectfour.assets.Board;
import connectfour.assets.Player;
import connectfour.strategy.*;

public class Game {
	
	private Board board;
	private int winCond;
	private int rows;
	private int cols;
	private Player[] players;
	
	/** Constructs a default game of connect four.<BR>
	 *  Human vs. Human on a default 6 row, 7 column board<br>
	 *  with 4 consecutive chips to win
	 */
	public Game() { 
		this.rows = 6;
		this.cols = 7;
		board = new Board(rows,cols);
		this.winCond = 4;
		players = new Player[2];
		players[0] = new Player(1, new HumanStrategy());
		players[1] = new Player(2, new HumanStrategy());
	}
	
	/**Constructs a new custom connect four game
	 * @param players Array of 2 players that play the game
	 * @param board The Gameboard
	 * @param winCond the winning condition
	 */
	public Game(Player[] players, Board board, int winCond) {
		this.players = players;
		this.board = board;
		this.winCond = winCond;
		this.rows = board.getRows();
		this.cols = board.getCols();
	}
	
	public void init() {
		board.init();
		players[0].init();
		players[1].init();
	}

}
