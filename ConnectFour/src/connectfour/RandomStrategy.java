package connectfour;

import java.util.Random;

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
