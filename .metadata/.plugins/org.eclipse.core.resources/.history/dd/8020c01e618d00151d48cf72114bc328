import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Card Description: 
 * Buddy Up
 * Play in EAT Room (18) or George Allen Field (0)
 * Success: Get 1 Learning pts or get 1 Craft pts
 * Fail: nothing
 * @author sam
 *
 */
public class Card13 extends Card{

	//constructor
		public Card13() {
			name = "Buddy Up";
			//no point requirement
			checkReqPts = false;
			//lay in EAT Room (18) or George Allen Field (0)
			checkReqLoc = true;
			reqLocation.add(18);
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
		//NEED: implement way to choose the reward(pop-up)
		player.updateLearningPts(1);
		return player;
	}

	@Override
	//Fail: Nothing happen
	public Player fail(Player player) {
		return player;
	}

}