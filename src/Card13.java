import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Card Description: 
 * Late for Class
 * Play in outside space except Forbidden Parking (0, 1, 2, 3, 4, 5, 7, 8, 9, 10)
 * Success: Get 1 Craft pts, Move to Lactation Lounge (20)
 * Fail: nothing
 * @author sam
 *
 */
public class Card13 extends Card{

	//constructor
		public Card13() {
			name = "Late for Class";
			//no point requirement
			checkReqPts = false;
			//Play in outside
			checkReqLoc = true;
			for(int i = 0; i <= 10; i++) {
				reqLocation.add(i);
			}
			reqLocation.remove(6); //except Forbidden Parking
			//initialize image
			try {
				img = ImageIO.read(new File("img/card15.png"));
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
		player.updateCraftPts(1);
		player.setLoc(20);
		return player;
	}

	@Override
	//Fail: Nothing happen
	public Player fail(Player player) {
		return player;
	}

}