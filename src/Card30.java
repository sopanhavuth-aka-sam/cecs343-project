import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Card Description: 
 * Soccer Goalie
 * Play in George Allen Field
 * Prerequisites:
 * 3 learning pts
 * 3 craft pts
 * Success: 
 * Get 5 quality pts
 * Get 1 game card
 * Fail: Go to student parking
 * @author Hieu Tran
 *
 */

public class Card30 extends Card {

	public Card30() {
		name = "Soccer Goalie";
		//Required 3 learning pts, 3 craft pts
		checkReqPts = true;
		reqLearningPts = 3;
		reqCraftPts = 3;
		//Play in George Allen Field
		checkReqLoc = true;
		reqLocation.add(0);
		//initialize image
		try {
			img = ImageIO.read(new File("img/card30.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
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
	//Success: Get 5 quality pts, 1 game card
	public Player win(Player player) {
		player.updateQP(5);
		//player.updateGameCard(1);
		return player;
	}

	@Override
	//Fail: Go to student parking
	public Player fail(Player player) {
		player.setLoc(2);
		return player;
	}
}
