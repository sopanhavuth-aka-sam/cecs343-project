import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * Card Description: 
 * Parking Violation
 * Play in Forbidden Parking
 * Success: 
 * Get 1 learning pt
 * Discard 1 Game Card to get another learning pts
 * Fail: nothing
 * @author Hieu Tran
 *
 */

public class Card8 extends Card{

	public Card8() {
		name = "Parking Violation";
		//no point requirement
		checkReqPts = false;
		//Play in Forbidden Parking
		checkReqLoc = true;
		reqLocation.add(6);
		//initialize image
		try {
			img = ImageIO.read(new File("img/card8.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Override
	//Success: Get 1 Learning chip; Discard 1 card and get 1 more Learning chip
	public Player win(Player player) {
		//add 1 learning chip
		player.updateLearningPts(1);
		//create arraylist of cardName in the hand; excluding this card
		ArrayList<String> cardName = new ArrayList<String>();
		for (int i = 0; i < hand.size(); i++) {
			if(!name.equals(hand.getCard(i).getName())){
				cardName.add(hand.getCard(i).getName());
			}
		}
		//convert arraylist of cardName into array Object[]
		Object[] option = cardName.toArray();
		String input = (String) JOptionPane.showInputDialog(null, "Choose now...",
	            "Choose a point", JOptionPane.PLAIN_MESSAGE, null,
	            option, option[1]);
		//remove card(input) from hand
		for (int i = 0; i < hand.size(); i++) {
			if(hand.getCard(i).getName().equals(input)) {
				hand.removeCard(i);
			}
		}
		//add 1 learning chip
		player.updateLearningPts(1);
		return player;
	}

	@Override
	//Fail: Nothing happen
	public Player fail(Player player) {
		return player;
	}
	
}
