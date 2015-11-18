import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Card Description: 
 * Professor Englert
 * Play in CECS Conference (19)
 * Prerequisite: 3 integrity
 * Success: Get 1 point of you choice
 * Fail: Discard 1 game card
 * @author sam
 *
 */
public class Card29 extends Card{

	//constructor
		public Card29() {
			name = "Professor Englert";
			//Prerequisite: 3 integrity
			checkReqPts = true;
			reqIntegrityPts = 3;
			//Play in CECS Conference (19)
			checkReqLoc = true;
			reqLocation.add(19);
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
		//choose a chip of your choice
		return player;
	}

	@Override
	//Fail: discard 1 game card from player's hand
	public Player fail(Player player) {
		return player;
	}

}