package connectfour.assets;

import connectfour.strategy.MoveStrategy;

public class Player {
	
	MoveStrategy strategy;
	int playerNumber;
	
	public Player(int playerNumber, MoveStrategy strategy) {
		this.strategy = strategy;
	}

	public void setStrategy(MoveStrategy strategy) {
		this.strategy = strategy;
	}
	
	
	public int makeMove(Board board) {
		return strategy.makeMove(this, board);
	}
	
}
