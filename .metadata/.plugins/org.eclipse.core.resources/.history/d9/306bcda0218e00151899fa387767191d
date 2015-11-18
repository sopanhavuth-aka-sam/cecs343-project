import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Card Description: 
 * Loud Buzzing
 * Play in EAT Room
 * Prerequisites:
 * 3 crafting pts
 * Success: 
 * A chip of choice
 * Fail: Lose 2 quality pts
 * @author Hieu Tran
 *
 */

public class Card26 extends Card {
	
	public Card26() {
		name = "Loud Buzzing";
		//Required 3 crafting pts
		checkReqPts = true;
		reqCraftPts = 3;
		//Play in Computer Lab
		checkReqLoc = true;
		reqLocation.add(18);
		//initialize image
		try {
			img = ImageIO.read(new File("img/card26.png"));
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
	//Fail: Lose 2 quality points
	public Player fail(Player player) {
		player.updateQP(-2);
		return player;
	}
}
