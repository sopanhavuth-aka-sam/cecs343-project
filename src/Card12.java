import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Card Description: 
 * Buddy Up
 * Join EAT or Soccer Team
 * Play in EAT room or George Allen Field
 * Success: 
 * Get 1 learning pt or 1 crafting pt
 * Fail: nothing
 * @author Hieu Tran
 *
 */

public class Card12 extends Card {
	
	public Card12() {
		name = "Join EAT or Soccer Team";
		//no point requirement
		checkReqPts = false;
		//Play in EAT Room or George Allen Field
		checkReqLoc = true;
		reqLocation.add(18);
		reqLocation.add(0);
		//initialize image
		try {
			img = ImageIO.read(new File("/img/card12.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
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
	//Success: Get 1 learning pt or 1 quality pt
	public Player win(Player player) {
		//if(player.chooseLearningPts()){
			player.updateLearningPts(1);
		//}
		/*else if(player.chooseCraftPts()){
			player.updateCraftPts(1);
		}*/
		return player;
	}

	@Override
	//Fail: Nothing happen
	public Player fail(Player player) {
		return player;
	}
	
}
