package connectfour;

public class Main {

	public static void main(String[] args) {
		Board board = new Board();
		TxtGUI gui=new TxtGUI(board);
		
		gui.drawBoard();
		
		

	}

}
