import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Card Description: 
 * Finding the Lab
 * Play in Elevators (16)
 * Success: Get 1 Integrity pts
 * Fail: nothing
 * @author sam
 *
 */
public class Card9 extends Card{

	//constructor
		public Card9() {
			name = "Finding the Lab";
			//no point requirement
			checkReqPts = false;
			//Play in Elevators (16)
			checkReqLoc = true;
			reqLocation.add(16);
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
		return player;
	}

	@Override
	//Fail: Nothing happen
	public Player fail(Player player) {
		return player;
	}

}