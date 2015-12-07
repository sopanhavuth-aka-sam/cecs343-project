import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Card Description: 
 * Elective Class
 * Play in Library (7)
 * Prerequisite: 2 learning
 * Success: Get 1 learning pts and 1 game card
 * Fail: lose 2 QP
 * @author sam
 *
 */
public class Card31 extends Card{

	//constructor
		public Card31() {
			name = "Elective Class";
			//no point requirement
			checkReqPts = true;
			reqLearningPts = 2;
			//Play in Library (7)
			checkReqLoc = true;
			reqLocation.add(7);
			//initialize image
			try {
				img = ImageIO.read(new File("img/card31.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	@Override
	//Win: get 1 learning chip; get 1 game card
	public Player win(Player player) {
		player.updateLearningPts(1);
		//add draw and add 1 card to hand
		hand.addCard(deck.deal());
		return player;
	}

	@Override
	//Fail: Lose 2 QP
	public Player fail(Player player) {
		player.updateQP(2);
		return player;
	}

}