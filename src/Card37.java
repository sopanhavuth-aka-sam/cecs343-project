import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * Card Description: 
 * Make a Friend
 * Play in North (12) or South Hall (15) 
 * Prerequisite: 2 integrity
 * Success: get 3 QP and a pts of your choice
 * Fail: discard 1 game card
 * @author sam
 *
 */
public class Card37 extends Card{

	//constructor
	public Card37() {
		name = "Make a Friend";
		//Prerequisite: 2 integrity
		checkReqPts = true;
		reqIntegrityPts = 2;
		//Play in outside
		checkReqLoc = true;
		reqLocation.add(12);
		reqLocation.add(15);
		//initialize image
		try {
			img = ImageIO.read(new File("img/card37.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		

	@Override
	//Win: get 3 QP; Get a chip of your choice
	public Player win(Player player) {
		//get 3 qp
		player.updateQP(3);
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
	//Fail: discard 1 game card
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