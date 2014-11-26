package connectfour.strategy;

import java.util.Random;

import connectfour.assets.Board;

public class FollowStrategy implements MoveStrategy {

	private Board oldBoard;
	private Random rnd;

	@Override
	public int makeMove(Board board) {
		int col = 0;
		if (oldBoard != null) {
			// not the first move for the computer player
			// generate a new (empty) board with the same
			// dimensions as the actual game board, but empty
			oldBoard = new Board(board.getRows(), board.getCols());
		}
		col = getDiff(board);

		if ((col == -1) || (!board.isValid(col))) {
			// Either empty board (col = -1) or
			// column is already full,
			// do random move
			do {
				col = rnd.nextInt(board.getCols());
			} while (!board.isValid(col));
		}

		oldBoard = new Board(board); // Use the copy constructor
		return col;
	}

	private int getDiff(Board board) {
		for (int row = 0; row < board.getRows(); row++) {
			for (int col = 0; col < board.getCols(); col++) {
				if (oldBoard.getValueAt(row, col) != board.getValueAt(row, col)) {
					return col; // difference found, return col
				}
			}
		}
		return -1; // no difference found
	}

}
