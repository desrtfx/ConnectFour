package connectfour;

public class Cell {
	private int row;
	private int col;
	
	public Cell() {
		this(0,0);
	}
	
	public Cell(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public Cell(Cell cell) {
		this.row = cell.getRow();
		this.col = cell.getCol();
	}
	
	public int getRow() {
		return row;
	}
	
	public void setRow(int row) {
		this.row = row;
	}
	
	public int getCol() {
		return col;
	}
	
	public void setCol(int col) {
		this.col = col;
	}
}
