import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Card Description: 
 * Fall in the Pond
 * Play in Japanese Garden
 * Prerequisites:
 * 3 learning pts
 * Success: 
 * Get 1 craft pt or 1 integrity pt
 * Fail: Go to Lactation Lounge
 * @author Hieu Tran
 *
 */

public class Card22 extends Card {
	
	public Card22() {
		name = "Fall in the Pond";
		//Required 3 learning pts
		checkReqPts = true;
		reqLearningPts = 3;
		//Play in Japanese Garden
		checkReqLoc = true;
		reqLocation.add(1);
		//initialize image
		try {
			img = ImageIO.read(new File("img/card22.png"));
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
	//Success: Get 5 quality pts
	public Player win(Player player) {
		//if(player.chooseCraftPts()){
			player.updateCraftPts(1);
		//}
		/*else {
			player.updateIntegrityPts(1);
		}*/
		return player;
	}

	@Override
	//Fail: Go to Lactation Lounge
	public Player fail(Player player) {
		player.setLoc(20);
		return player;
	}

}
