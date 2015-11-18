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
public class Card33 extends Card{

	//constructor
		public Card33() {
			name = "Exercising Mind and Body";
			//no point requirement
			checkReqPts = false;
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
		player.updateLearningPts(1);
		//get 1 game card
		return player;
	}

	@Override
	//Fail: Lose 2 QP
	public Player fail(Player player) {
		player.updateQP(2);
		return player;
	}

}