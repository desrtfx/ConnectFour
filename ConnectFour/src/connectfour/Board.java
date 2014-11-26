package connectfour;

public class Board {

	// the actual game board
	private int[][] board;

	// Board dimensions for easy access
	private int rows;
	private int cols;

	public Board() {
		this(6, 7);
	}

	public Board(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		board = new int[this.rows][this.cols];
	}

	public int[][] getBoard() {
		return board;
	}

	public int getCellAt(int row, int col) {
		if ((row < 0) || (row >= rows)) {
			throw new IndexOutOfBoundsException(
					"The supplied Row Index is out of bounds.");
		}
		if ((col < 0) || (col >= cols)) {
			throw new IndexOutOfBoundsException(
					"The supplied Column Index is out of bounds.");
		}
		return board[row][col];
	}

	public int getCols() {
		return cols;
	}
	
	public int getRows() {
		return rows;
	}
	
	public int[] getRow(int row) {
		if ((row < 0) || (row >= rows)) {
			throw new IndexOutOfBoundsException(
					"The supplied Row Index is out of bounds.");
		}
		return board[row];
	}
	
	
}