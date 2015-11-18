import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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
		//NEED: choose a point; 
		return player;
	}

	@Override
	//Fail: Discard 1 game card from player
	public Player fail(Player player) {
		return player;
	}

}