package connectfour;

public interface MoveStrategy {

	/**Executes a move from a player
	 * @param board the Game board
	 * @return a valid column number where the next chip should go
	 */
	public int makeMove(Board board);
	
}
