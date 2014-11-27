package connectfour.strategy;

import connectfour.assets.Board;
import connectfour.assets.Player;

public interface MoveStrategy {

	/**Executes a move from a player
	 * @param current the player whose move it is
	 * @param other the opponent
	 * @param board the Game board
	 * @return a valid column number where the next chip should go
	 * or -1 to quit the game
	 */
	public int makeMove(Player current, Player other, Board board);
	
}
