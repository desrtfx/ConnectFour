package connectfour.assets;

public class Board {

	// the actual game board
	private int[][] board;

	// Board dimensions for easy access
	private final int rows;
	private final int cols;

	private int chipCount;

	public Board() {
		this(6, 7);
	}

	public Board(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		board = new int[this.rows][this.cols];
		chipCount = 0;
	}

	public Board(Board board) {
		this.rows = board.getRows();
		this.cols = board.getCols();
		this.board = new int[this.rows][this.cols];
		chipCount = 0;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				this.board[row][col] = board.getValueAt(row, col);
				if (this.board[row][col] != 0) {
					chipCount++;
				}
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
		updateChipCount();
	}

	private void updateChipCount() {
		chipCount = 0;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (board[row][col] != 0) {
					chipCount++;
				}
			}
		}
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

	// returns the chipCount to speed winner analysis
	public int getChipCount() {
		return chipCount;
	}

	public int[] getRow(int row) {
		if ((row < 0) || (row >= rows)) {
			throw new IndexOutOfBoundsException(
					"The supplied Row Index is out of bounds.");
		}
		return board[row];
	}

	public boolean isValid(int col) {
		return (board[rows - 1][col] == 0);
	}

	public void dropChip(int player, int col) {
		for (int i = 0; i < rows; i++) {
			if (board[i][col] == 0) {
				board[i][col] = player;
				chipCount++;
				break;
			}
		}
	}

	public boolean isEmpty() {
		return (chipCount == 0);
	}

	public boolean isFull() {
		return (chipCount == (rows * cols));
	}

	/**
	 * 
	 */
	public void init() {
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				board[row][col] = 0;
			}
		}
		chipCount = 0;
	}

	private boolean checkGroup(int player, int startRow, int startCol,
			int offsRow, int offsCol, int winCond) {
		for (int i = 0; i < winCond; i++) {
			if (board[startRow + offsRow * i][startCol + offsCol * i] != player) {
				return false;
			}
		}
		return true;
	}

	private boolean checkHoriz(int player, int winCond) {
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols - winCond; col++) {
				if (checkGroup(player, row, col, 0, 1, winCond)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean checkVert(int player, int winCond) {
		for (int row = 0; row < rows - winCond; row++) {
			for (int col = 0; col < cols; col++) {
				if (checkGroup(player, row, col, 1, 0, winCond)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean checkBLTR(int player, int winCond) {
		for (int row = 0; row < rows - winCond; row++) {
			for (int col = 0; col < cols - winCond; col++) {
				if (checkGroup(player, row, col, 1, 1, winCond)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean checkTLBR(int player, int winCond) {
		for (int row = winCond - 1; row < rows; row++) {
			for (int col = 0; col < cols - winCond; col++) {
				if (checkGroup(player, row, col, 1, -1, winCond)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean checkBoard(int player, int winCond) {
		// There need to be at least 7 chips on the board
		// before there can be a winner
		if (chipCount < 7) {
			return false;
		}
		// Horizontal "-"
		if (checkHoriz(player, winCond)) {
			return true;
		}
		// Vertical "|"
		if (checkVert(player, winCond)) {
			return true;
		}
		// Diagonal bottom left to top right "/"
		if (checkBLTR(player, winCond)) {
			return true;
		}
		// Diagonal top left to bottom right "\"
		if (checkTLBR(player, winCond)) {
			return true;
		}
		return false;
	}
}
