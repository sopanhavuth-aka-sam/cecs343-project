import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Card Description: 
 * Professor Hoffman
 * Play in any room in ECS (11, 13, 14, 17, 18, 19) except Lactation Lounge
 * Prerequisite: 3 learning
 * Success: Get 5 QP and 2 game cards
 * Fail: lose 5 QP and to to Lactation Lounge (20)
 * @author sam
 *
 */
public class Card33 extends Card{

	//constructor
		public Card33() {
			name = "Professor Hoffman";
			//Prerequisite: 3 learning
			checkReqPts = true;
			reqLearningPts = 3;
			//Play in any room in ECS (11, 13, 14, 17, 18, 19) except Lactation Lounge
			checkReqLoc = true;
			reqLocation.add(11);
			reqLocation.add(13);
			reqLocation.add(14);
			reqLocation.add(17);
			reqLocation.add(18);
			reqLocation.add(19);
			//initialize image
			try {
				img = ImageIO.read(new File("img/card33.png"));
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
		//get 2 game cards
		return player;
	}

	@Override
	public Player fail(Player player) {
		player.updateQP(-5);
		player.setLoc(20);
		return player;
	}

}