import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Card Description: 
 * Score a Goal!
 * Play in George Allen Field (0)
 * Prerequisite: 3 craft
 * Success: Get 5 QP and 1 integrity
 * Fail: go to student parking (2)
 * @author sam
 *
 */
public class Card21 extends Card{

	//constructor
		public Card21() {
			name = "Score a Goal!";
			//Prerequisite: 3 craft
			checkReqPts = true;
			reqCraftPts = 3;
			//Play in George Allen Field (0)
			checkReqLoc = true;
			reqLocation.add(0);
			//initialize image
			try {
				img = ImageIO.read(new File("img/card21.png"));
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
		player.updateQP(5);
		player.updateIntegrityPts(1);
		return player;
	}

	@Override
	public Player fail(Player player) {
		player.setLoc(2);
		return player;
	}

}