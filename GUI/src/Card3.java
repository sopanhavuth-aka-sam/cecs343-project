import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Card Description: 
 * Math 122
 * Play in library(7)
 * Success: Get 1 learning pts or get 1 integrity chip
 * Fail: nothing
 * @author sam
 *
 */
public class Card3 extends Card{

	//constructor
		public Card3() {
			name = "Math 122";
			//no point requirement
			checkReqPts = false;
			//Play in library(7)
			checkReqLoc = true;
			reqLocation.add(7);
			//initialize image
			try {
				img = ImageIO.read(new File("img/card3.png"));
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
		//NEED: implement way to choose the reward(pop-up)
		//For not get 1 learning pts
		player.updateLearningPts(1);
		return player;
	}

	@Override
	//Fail: Nothing happen
	public Player fail(Player player) {
		return player;
	}

}
