import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Card Description: 
 * Learning Linux
 * Play in Computer Lab
 * Prerequisites:
 * 2 crafting pts
 * 3 integrity pts
 * Success: 
 * Get 3 quality pts
 * A chip of choice
 * Fail: Lose 1 quality pt
 * @author Hieu Tran
 *
 */

public class Card36 extends Card{
	
	public Card36() {
		name = "Learning Linux";
		//Required 2 crafting pts, 3 integrity pts
		checkReqPts = true;
		reqCraftPts = 2;
		reqIntegrityPts = 3;
		//Play in Computer Lab
		checkReqLoc = true;
		reqLocation.add(11);
	
		//initialize image
		try {
			img = ImageIO.read(new File("img/card36.png"));
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
	//Success: Get 3 quality pts, a chip of choice
	public Player win(Player player) {
		player.updateQP(3);
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
	//Fail: Lose 1 quality pt
	public Player fail(Player player) {
		player.updateQP(-1);
		return player;
	}

}
