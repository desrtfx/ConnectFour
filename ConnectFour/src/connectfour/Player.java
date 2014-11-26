package connectfour;

public class Player {
	
	MoveStrategy strategy;
	
	public Player(MoveStrategy strategy) {
		this.strategy = strategy;
	}

}
