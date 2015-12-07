import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * Card Description: 
 * Meet the Dean
 * Play in North (12) or South Hall (13)
 * Prerequisite: 3 learning, 3 craft, and 3 integrity
 * Success: Get 5 QP and draw 1 Game card
 * Fail: discard 1 game card
 * @author sam
 *
 */
public class Card25 extends Card{

	//constructor
	public Card25() {
		name = "Meet the Dean";
		//Prerequisite: 3 learning, 3 craft, and 3 integrity
		checkReqPts = true;
		reqLearningPts = 3;
		reqCraftPts = 3;
		reqIntegrityPts = 3;
		//Play in North (12) or South Hall (15)
		checkReqLoc = true;
		reqLocation.add(12);
		reqLocation.add(15);
		//initialize image
		try {
			img = ImageIO.read(new File("img/card25.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		

	@Override
	//Win: 5 QP, draw 1 game card
	public Player win(Player player) {
		//Get 5 QP
		player.updateQP(5);
		//add draw and add 1 card to hand
		try {
			hand.addCard(deck.deal());
		} catch(NullPointerException e) {
			System.out.println("Ai try to draw card");
		}
		
		return player;
	}

	@Override
	//Fail: Discard 1 game card from player
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