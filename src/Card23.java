import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Card Description: 
 * Fall in the Pond
 * Play in Japanese Garden (1)
 * Prerequisite: 3 learning
 * Success: Get 1 Integrity pts and 1 craft pts
 * Fail: go to Lactation Lounge (20)
 * @author sam
 *
 */
public class Card23 extends Card{

	//constructor
		public Card23() {
			name = "Fall in the Pond";
			//Prerequisite: 3 learning
			checkReqPts = true;
			reqLearningPts = 3;
			//Play in Student Recreation (5)
			checkReqLoc = true;
			reqLocation.add(5);
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
		player.updateIntegrityPts(1);
		player.updateCraftPts(1);
		return player;
	}

	@Override
	//Fail: go to Lactation Lounge (20)
	public Player fail(Player player) {
		player.setLoc(20);
		return player;
	}

}