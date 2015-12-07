import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * Card Description: 
 * Program Crashes
 * Play in Lactation Lounge (20)
 * Prerequisite: 2 learning
 * Success: Get 5 QP and 1 pts of your choice
 * Fail: discard 1 game card
 * @author sam
 *
 */
public class Card27 extends Card{

	//constructor
		public Card27() {
			name = "Program Crashes";
			//Prerequisite: 2 learning
			checkReqPts = true;
			reqLearningPts = 2;
			//Play in Lactation Lounge (20)
			checkReqLoc = true;
			reqLocation.add(20);
			//initialize image
			try {
				img = ImageIO.read(new File("img/card27.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	@Override
	//Win: 5 QP and choose 1 chip
	public Player win(Player player) {
		//get 5 qp
		player.updateQP(5);
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
	//Fail: Discard 1 game card from player
	public Player fail(Player player) {
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
		return player;
	}

}