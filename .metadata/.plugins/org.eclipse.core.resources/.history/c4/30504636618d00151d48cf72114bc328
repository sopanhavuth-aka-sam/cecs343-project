import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Card Description: 
 * KIN 253
 * Play in George Allen Field (0)
 * Require Point: 4 Integrity
 * Success: Get 2 Craft
 * Fail: go to Room of Retirement (13)
 * @author sam
 *
 */
public class Card17 extends Card{

	//constructor
		public Card17() {
			name = "KIN 253";
			//require: 4 Integrity
			checkReqPts = true;
			reqCraftPts = 4;
			//Play in George Allen Field (0)
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
		player.updateCraftPts(2);
		return player;
	}

	@Override
	//Fail: go to Room of Retirement (13)
	public Player fail(Player player) {
		player.setLoc(13);
		return player;
	}

}