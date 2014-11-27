package connectfour.strategy;

import java.util.Random;

import connectfour.assets.Board;
import connectfour.assets.Player;
import connectfour.gui.TxtGUI;

public class FollowStrategy implements MoveStrategy {

	private Random rnd;

	// Computer will never quit!
	@Override
	public int makeMove(Player current, Player other, Board board, TxtGUI gui) {
		int col = other.getLastCol();

		if ((col == -1) || (!board.isValid(col))) {
			// Either first move (col = -1) or
			// column is already full,
			// do random move
			do {
				col = rnd.nextInt(board.getCols());
			} while (!board.isValid(col));
		}

		return col;
	}
}
