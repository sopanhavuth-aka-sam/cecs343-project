import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * Card Description: 
 * Professor Englert
 * Play in CECS Conference
 * Prerequisites:
 * 3 integrity pts
 * Success: 
 * Get a chip of choice
 * Fail: Discard 1 game card
 * @author Hieu Tran
 *
 */

public class Card28 extends Card {
	
	public Card28() {
		name = "Professor Englert";
		//Required 3 integrity pts
		checkReqPts = true;
		reqIntegrityPts = 3;
		//Play in CECS Conference
		checkReqLoc = true;
		reqLocation.add(19);
		//initialize image
		try {
			img = ImageIO.read(new File("img/card28.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Override
	//Win: choose 1 chip
	public Player win(Player player) {
		//choose 1 point
		Object[] option = {"Learning", "Integrity", "Craft"};
		String input = (String) JOptionPane.showInputDialog(null, "Choose now...",
	            "Choose a point", JOptionPane.PLAIN_MESSAGE, null,
	            option, option[1]);
		if(input.equals("Learning")) {
			player.updateLearningPts(1);
		}
		else if (input.equals("Integrity")) {
			player.updateIntegrityPts(1);
		}
		else { //Craft
			player.updateCraftPts(1);
		}
		return player;
	}

	@Override
	//Fail: Discard 1 game card
	public Player fail(Player player) {
		try {
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
					"Choose a card to discard", JOptionPane.PLAIN_MESSAGE, null,
		            option, option[1]);
			//remove card(input) from hand
			for (int i = 0; i < hand.size(); i++) {
				if(hand.getCard(i).getName().equals(input)) {
					hand.removeCard(i);
				}
			}
		} catch(NullPointerException e) {
			System.out.println("AI try to discard card from hand");
		}
		return player;
	}
	
}
