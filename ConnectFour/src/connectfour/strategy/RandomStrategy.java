package connectfour.strategy;

import java.util.Random;

import connectfour.assets.Board;
import connectfour.assets.Player;
import connectfour.gui.TxtGUI;

public class RandomStrategy implements MoveStrategy {

	Random rnd = new Random();
	
	// Computer will never quit!
	@Override
	public int makeMove(Player current, Player other, Board board, TxtGUI gui) {
		int col;
		do {
			col = rnd.nextInt(board.getCols());
		} while (!board.isValid(col));
		return col;
	}

}
