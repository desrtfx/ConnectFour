package connectfour.strategy;

import connectfour.assets.Board;
import connectfour.assets.Player;
import connectfour.gui.TxtGUI;

public class HumanStrategy implements MoveStrategy {
	
	@Override
	public int makeMove(Player current, Player other, Board board, TxtGUI gui) {
		
		return gui.askPlayerMove(current.getPlayerNumber());
	}

}
