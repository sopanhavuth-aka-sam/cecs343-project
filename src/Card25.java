import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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
			//Play in North (12) or South Hall (13)
			checkReqLoc = true;
			reqLocation.add(12);
			reqLocation.add(13);
			//initialize image
			try {
				img = ImageIO.read(new File("img/card27.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	/*@Override
	public Player play(Player player) {
		//boolean flag identifying if the play successes or fail
		boolean result = false;
		//points and location validation: this determine if the play is successes
		//or fail
		if(checkReqPts) {
			result = validatePts(player);
		}
		if(checkReqLoc) {
			result = validateLoc(player);
		}
		//calling win() or fail() method base on "result"
		if(result) {
			return win(player);
		}
		else {
			return fail(player);
		}
	}*/

	@Override
	public Player win(Player player) {
		player.updateQP(3);
		//NEED: function to draw one game card.
		return player;
	}

	@Override
	//Fail: Discard 1 game card from player
	public Player fail(Player player) {
		return player;
	}

}