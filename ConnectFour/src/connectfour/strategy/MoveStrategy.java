package connectfour.strategy;

import connectfour.assets.Board;
import connectfour.assets.Player;

public interface MoveStrategy {

	/**Executes a move from a player
	 * @param player the player whose move it is
	 * @param board the Game board
	 * @return a valid column number where the next chip should go
	 */
	public int makeMove(Player player, Board board);
	
}
