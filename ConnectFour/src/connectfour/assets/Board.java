package connectfour.assets;


public class Board {

	// the actual game board
	private int[][] board;

	// Board dimensions for easy access
	private final int rows;
	private final int cols;

	public Board() {
		this(6, 7);
	}

	public Board(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		board = new int[this.rows][this.cols];
	}

	public Board(Board board) {
		this.rows = board.getRows();
		this.cols = board.getCols();
		this.board = new int[this.rows][this.cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				this.board[row][col] = board.getValueAt(row, col);
			}
		}
	}

	public int[][] getBoard() {
		return board;
	}

	public int getValueAt(int row, int col) {
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

	public int getVauleAt(Cell cell) {
		return getValueAt(cell.getRow(), cell.getCol());
	}

	public void setValueAt(int row, int col, int value) {
		if ((row < 0) || (row >= rows)) {
			throw new IndexOutOfBoundsException(
					"The supplied Row Index is out of bounds.");
		}
		if ((col < 0) || (col >= cols)) {
			throw new IndexOutOfBoundsException(
					"The supplied Column Index is out of bounds.");
		}
		if ((value < 0) || (value > 2)) {
			throw new IllegalArgumentException("The supplied value is invalid.");
		}
		board[row][col] = value;
	}

	public void setValueAt(Cell cell, int value) {
		setValueAt(cell.getRow(), cell.getCol(), value);
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
	
	public boolean isValid(int col) {
		return (board[rows-1][col]==0);
	}

}
