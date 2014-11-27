package connectfour.gui;

import java.util.Scanner;

import connectfour.assets.Board;

public class TxtGUI {

	private static final int NOT_VALID = -2;
	
	private Board board;
	private Scanner sc;
	
	
	public TxtGUI(Board board) {
		this.board = board;
		// this.sc = new Scanner(System.in);
	}

	public TxtGUI(Board board, Scanner sc) {
		this.board = board;
		this.sc = sc;
	}
	
	public void setBoard(Board board) {
		this.board = board;
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

	public int askPlayerMove(int player) {
		// On demand Scanner initialization
		if (sc == null) {
			sc = new Scanner(System.in);
		}
		int move = NOT_VALID; // Initialize to "no move"
		String answer;
		do {
			System.out.println();
			System.out.print("Player: " + player + " make your move (0.." +
			    (board.getRows()-1) + "), or type 'q' to quit: ");
			answer = sc.nextLine();
			if (answer.length() > 1) {
				answer = answer.substring(0,1).toLowerCase();
			}
			if ("q".equalsIgnoreCase(answer)) {
				return -1;
			}
			if (Character.isDigit(answer.charAt(0))) {
				move = Integer.parseInt(answer.substring(0,1));
			}
			move = (board.isValid(move)) ? move : NOT_VALID;
			if (move == NOT_VALID) {
				System.out.println("Invalid answer, please try again!");
			}
		} while (move == NOT_VALID);
		
		return move;
	}

	
	
	// --- Private Auxiliary Methods ---
	
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
	

}
