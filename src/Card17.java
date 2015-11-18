import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Card Description: 
 * Math 123
 * Play in ECS 302 (14) or 308 (17)
 * Require Point: 5 learning
 * Success: get 5 QP
 * Fail: lose 3 QP and lose 1 game card
 * @author sam
 *
 */
public class Card17 extends Card{

	//constructor
	public Card17() {
		name = "Math 123";
		//require: 5 learning
		checkReqPts = true;
		reqCraftPts = 5;
		//Play in ECS 302 (14) or 308 (17)
		checkReqLoc = true;
		reqLocation.add(14);
		reqLocation.add(17);
		//initialize image
		try {
			img = ImageIO.read(new File("img/card17.png"));
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
		//lose 1 game card
		return player;
	}

	@Override
	public Player fail(Player player) {
		player.updateQP(-3);
		return player;
	}

}