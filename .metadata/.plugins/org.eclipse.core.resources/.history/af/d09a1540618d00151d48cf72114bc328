import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Card Description: 
 * Learning Netbeans
 * Play in Lactation Lounge (20)
 * Success: Get 5 QP
 * Fail: Lose 3 QP
 * @author sam
 *
 */
public class Card19 extends Card{

	//constructor
		public Card19() {
			name = "Learning Netbeans";
			//no point requirement
			checkReqPts = false;
			//Play in Lactation Lounge (20)
			checkReqLoc = true;
			reqLocation.add(20);
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
		player.updateQP(5);
		return player;
	}

	@Override
	//Fail: Lose 3 QP
	public Player fail(Player player) {
		player.updateQP(-3);
		return player;
	}

}