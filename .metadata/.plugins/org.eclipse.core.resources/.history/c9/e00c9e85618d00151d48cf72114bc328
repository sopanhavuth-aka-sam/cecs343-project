import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Card Description: 
 * Soccer Goalie
 * Play in George Allen Field (0)
 * Prerequisites = 3 learning and 3 craft
 * Success: Get 5 QP
 * Fail: go to student parking
 * @author sam
 *
 */
public class Card31 extends Card{

	//constructor
		public Card31() {
			name = "Soccer Goalie";
			//Prerequisites = 3 learning and 3 craft
			checkReqPts = true;
			reqLearningPts = 3;
			reqCraftPts = 3;
			//Play in Student Recreation (5)
			checkReqLoc = true;
			reqLocation.add(0);
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
		player.updateQP(5);
		//draw 1 game card.
		return player;
	}

	@Override
	//Fail: go to student parking
	public Player fail(Player player) {
		player.setLoc(2);
		return player;
	}

}