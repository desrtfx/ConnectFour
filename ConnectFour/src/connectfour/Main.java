package connectfour;

import java.util.Random;

import connectfour.assets.Board;
import connectfour.gui.TxtGUI;

public class Main {

	public static void main(String[] args) {
		Board board = new Board();
		TxtGUI gui=new TxtGUI(board);
		Random rnd = new Random();
		
		gui.drawBoard();
		
		for(int row = 0; row < board.getRows();row++) {
			for(int col = 0; col < board.getCols(); col++) {
				board.setValueAt(row,col,rnd.nextInt(3));
			}
		}
		
		gui.drawBoard();
		

	}

}
