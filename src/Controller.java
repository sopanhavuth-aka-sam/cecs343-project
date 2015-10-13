import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener{
	
	private Board gameBoard;
	private Player humanPlayer;

	public Controller() {
		gameBoard = new Board();
		humanPlayer = new Player("Jimmy", 0, 0, 0, 0 , 0, 1, 1);
	}
	
	public void actionPerformed(ActionEvent e) {
	}

}
