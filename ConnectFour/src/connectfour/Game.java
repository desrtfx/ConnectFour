package connectfour;

public class Game {
	
	private Board board;
	private int winCond;
	private int rows;
	private int cols;
	private Player[] player;
	
	public Game() {
		this(6,7,4);
	}
	
	public Game(int rows, int cols, int winCond) {
		this.rows = rows;
		this.cols = cols;
		board = new Board(rows,cols);
		this.winCond = winCond;
	}

}
