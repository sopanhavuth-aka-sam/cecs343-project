import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Card Description: 
 * Goodbye, Professor
 * Play in Room of Retirement (13)
 * Require Point: 6 Learning, 6 Craft, and 6 Integrity
 * Success: Get 10 QP
 * Fail: Lose 1 game card; leave it in Room of Retirement
 * @author sam
 *
 */
public class Card11 extends Card{

	//constructor
		public Card11() {
			name = "Goodbye, Professor";
			//(6,6,6)
			checkReqPts = true;
			reqLearningPts = 6;
			reqCraftPts = 6;
			reqIntegrityPts = 6;
			//Play in Room of Retirement (13)
			checkReqLoc = true;
			reqLocation.add(13);
			//initialize image
			try {
				img = ImageIO.read(new File(""));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	@Override
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
	}

	@Override
	public Player win(Player player) {
		player.updateQP(10);
		return player;
	}

	@Override
	//NEED: implement way to leave behind card in a room
	//		room might need Arraylist to store card left behind
	public Player fail(Player player) {
		return player;
	}

}