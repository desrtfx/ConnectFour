package connectfour.strategy;

import java.util.Random;

import connectfour.assets.Board;
import connectfour.assets.Player;

public class RandomStrategy implements MoveStrategy {

	Random rnd = new Random();
	
	// Computer will never quit!
	@Override
	public int makeMove(Player current, Player other, Board board) {
		int col;
		do {
			col = rnd.nextInt(board.getCols());
		} while (!board.isValid(col));
		return col;
	}

}
