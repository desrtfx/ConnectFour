package connectfour.assets;

import connectfour.strategy.MoveStrategy;

public class Player {
	
	MoveStrategy strategy;
	
	public Player(MoveStrategy strategy) {
		this.strategy = strategy;
	}

}
