import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Card Description: 
 * Exercising Mind and Body
 * Play in Student Recreation (5)
 * Success: Get 1 Integrity pts
 * Fail: nothing
 * @author sam
 *
 */
public class Card7 extends Card{

	//constructor
		public Card7() {
			name = "Exercising Mind and Body";
			//no point requirement
			checkReqPts = false;
			//Play in Student Recreation (5)
			checkReqLoc = true;
			reqLocation.add(5);
			//initialize image
			try {
				img = ImageIO.read(new File("img/card7.png"));
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
		return player;
	}

	@Override
	//Fail: Nothing happen
	public Player fail(Player player) {
		return player;
	}

}