import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Card Description: 
 * Press the Right Floor
 * Play in Elevators (16)
 * Prerequisite: 4 learning
 * Success: Get 2 craft pts
 * Fail: lose 2 quality pts
 * @author sam
 *
 */
public class Card29 extends Card{

	//constructor
		public Card29() {
			name = "Press the Right Floor";
			//Prerequisite: 4 learning
			checkReqPts = true;
			reqLearningPts = 4;
			//Play in Play in Elevators (16)
			checkReqLoc = true;
			reqLocation.add(19);
			//initialize image
			try {
				img = ImageIO.read(new File("img/card29.png"));
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
	public Player fail(Player player) {
		player.updateQP(-2);
		return player;
	}

}