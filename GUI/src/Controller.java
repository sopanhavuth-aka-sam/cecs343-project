import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener{
	
	private Board gameBoard;
	private Display gameDisplay;
	private Player human, ai1, ai2;

	public Controller() {
		
		gameBoard = new Board();
		gameDisplay = new Display();
		human = new Player("Jimmy", 0, 0, 0, 0 , 0, 1, 1);
		ai1 = new Player("Mary", 0, 0, 0, 0 , 0, 1, 2);
		ai2 = new Player("Tom", 0, 0, 0, 0 , 0, 1, 3);
	}
	
	public void actionPerformed(ActionEvent e) {
	}

}
