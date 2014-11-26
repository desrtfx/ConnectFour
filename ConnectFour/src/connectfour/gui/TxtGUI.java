package connectfour.gui;

import connectfour.assets.Board;

public class TxtGUI {

	private Board board;
	
	public TxtGUI(Board board) {
		this.board = board;
	}
	
	private void drawBoardHeader() {
		for(int col = 0; col < board.getCols(); col++) {
			if (col==0) {
				System.out.print("|");
			}
			System.out.print(" " + String.format("%1d",col) + " |");
		}
		System.out.println();
	}
	
	private void drawBoardSeparator() {
		for(int col = 0; col < board.getCols(); col++) {
			if (col==0) {
				System.out.print("+");
			}
			System.out.print("---+");
		}
		System.out.println();
	}
	
	private void drawBoardRow(int row) {
		int[] currentRow = board.getRow(row);
		for(int col = 0; col < board.getCols(); col++) {
			if (col==0) {
				System.out.print("|");
			}
			System.out.print(" " + ((currentRow[col]==0)?" ":(currentRow[col]==1)?"X":"O") + " |");
		}
		System.out.println();
	}
	
	private void drawBoardTop() {
		System.out.println();
		drawBoardHeader();
		drawBoardSeparator();
	}

	private void drawBoardBottom() {
		drawBoardSeparator();
		drawBoardHeader();
		System.out.println();
	}
	
	public void drawBoard() {
		drawBoardTop();
		for(int row=board.getRows()-1; row >= 0; row--) {
			drawBoardRow(row);
			if (row!=0) {
				drawBoardSeparator();
			}
		}
		drawBoardBottom();
	}

}
