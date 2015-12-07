import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * Card Description: 
 * Car Pool
 * Play in either parking lot (2), (6)
 * require: 5 integrity
 * Success: Get 3 QP , 1 game card
 * Fail: Lose 2 QP
 * @author sam
 *
 */
public class Card41 extends Card{
	
	//constructor
	public Card41() {
		name = "Car Pool";
		//requirement 4 integrity
		checkReqPts = true;
		reqIntegrityPts = 5;
		//Play in either parking lot (2), (6)
		checkReqLoc = true;
		reqLocation.add(2);
		reqLocation.add(6);
		//initialize image
		try {
			img = ImageIO.read(new File("img/card41.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	//Win: Get 3 QP , 1 game card
	public Player win(Player player) {
		player.updateQP(3);
		//add draw and add 1 card to hand
		try {
		    hand.addCard(deck.deal());
		} catch(NullPointerException e) {
		    System.out.println("Ai try to draw card");
		}
		return player;
	}

	@Override
	//Fail: Lose 2 QP
	public Player fail(Player player) {
		player.updateQP(-2);
		return player;
	}

}