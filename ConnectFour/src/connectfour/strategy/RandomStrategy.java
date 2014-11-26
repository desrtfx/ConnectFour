package connectfour.strategy;

import java.util.Random;

import connectfour.assets.Board;

public class RandomStrategy implements MoveStrategy {

	Random rnd = new Random();
	
	@Override
	public int makeMove(Board board) {
		int col;
		do {
			col = rnd.nextInt(board.getCols());
		} while (!board.isValid(col));
		return col;
	}

}
