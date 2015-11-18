import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Card Description: 
 * Professor Englert
 * Play in CECS Conference
 * Prerequisites:
 * 3 integrity pts
 * Success: 
 * Get a chip of choice
 * Fail: Discard 1 game card
 * @author Hieu Tran
 *
 */

public class Card28 extends Card {
	
	public Card28() {
		name = "Professor Englert";
		//Required 3 integrity pts
		checkReqPts = true;
		reqIntegrityPts = 3;
		//Play in CECS Conference
		checkReqLoc = true;
		reqLocation.add(19);
		//initialize image
		try {
			img = ImageIO.read(new File("/img/card28.png"));
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
	//Success: Get 5 quality pts
	public Player win(Player player) {
		//player.updateQP(3);
		
		/*if(player.chooseLearningPts()){
			player.updateLearningPts(1);
		}
		else if(player.chooseCraftPts()){
			player.updateCraftPts(1);
		}
		else if(player.chooseIntegrityPts()){
			player.updateIntegrityPts(1);
		}*/
		return player;
	}

	@Override
	//Fail: Discard 1 game card
	public Player fail(Player player) {
		//player.updateGameCard(-1);
		return player;
	}
	
}
