import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Card Description: 
 * Lunch at Bratwurst Hall
 * Play in Bratwurst Hall (9)
 * Success: Get 1 Craft pts
 * Fail: nothing
 * @author sam
 *
 */
public class Card5 extends Card{

	//constructor
		public Card5() {
			name = "Lunch at Bratwurst Hall";
			//no point requirement
			checkReqPts = false;
			//Play in Bratwurst Hall (9)
			checkReqLoc = true;
			reqLocation.add(9);
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
		player.updateCraftPts(1);;
		return player;
	}

	@Override
	//Fail: Nothing happen
	public Player fail(Player player) {
		return player;
	}

}