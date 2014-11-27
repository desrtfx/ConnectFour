package connectfour.assets;

import connectfour.strategy.MoveStrategy;

public class Player {

	MoveStrategy strategy;
	int playerNumber;
	int lastCol;

	public Player(int playerNumber, MoveStrategy strategy) {
		this.strategy = strategy;
		this.playerNumber = playerNumber;
		lastCol = -1; // First move
	}

	public Player(int playerNumber) {
		this(playerNumber, null);
	}

	public void setStrategy(MoveStrategy strategy) {
		this.strategy = strategy;
	}

	public int getLastCol() {
		return lastCol;
	}

	public int makeMove(Player current, Player other, Board board) {
		if (strategy == null) {
			throw new NullPointerException("No strategy assigned.");
		}
		lastCol = strategy.makeMove(current, other, board);
		return lastCol;
	}

	public void init() {
		lastCol = -1;
	}

}
