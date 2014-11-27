package connectfour.assets;

import connectfour.gui.TxtGUI;
import connectfour.strategy.MoveStrategy;

public class Player {

	TxtGUI gui;
	MoveStrategy strategy;
	int playerNumber;
	int lastCol;

	public Player(int playerNumber, MoveStrategy strategy, TxtGUI gui) {
		this.gui = gui;
		this.strategy = strategy;
		this.playerNumber = playerNumber;
		lastCol = -1; // First move
	}

	public Player(int playerNumber) {
		this(playerNumber, null, null);
	}
	
	public int getPlayerNumber() {
		return playerNumber;
	}

	public void setStrategy(MoveStrategy strategy) {
		this.strategy = strategy;
	}
	
	public void setGUI(TxtGUI gui) {
		this.gui = gui;
	}

	public int getLastCol() {
		return lastCol;
	}

	public int makeMove(Player current, Player other, Board board) {
		if (strategy == null) {
			throw new NullPointerException("No strategy assigned.");
		}
		if (gui == null) {
			throw new NullPointerException("No GUI assigned.");
		}
		lastCol = strategy.makeMove(current, other, board, gui);
		return lastCol;
	}

	public void init() {
		lastCol = -1;
	}

}
