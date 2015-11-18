import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Card Description: 
 * CHEM 111
 * Play in any building not ECS
 * Prerequisites:
 * 6 crafting pts
 * Success: 
 * Get 5 quality pts
 * Fail: Go to student parking
 * @author Hieu Tran
 *
 */

public class Card34 extends Card{
	
	public Card34() {
		name = "CHEM 111";
		//Required 6 crafting pts
		checkReqPts = true;
		reqCraftPts = 6;
		//Play in any building not ECS
		checkReqLoc = true;
		reqLocation.add(2);
		reqLocation.add(3);
		reqLocation.add(5);
		reqLocation.add(7);
		reqLocation.add(8);
		reqLocation.add(9);
		//initialize image
		try {
			img = ImageIO.read(new File("img/card34.png"));
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
		player.updateQP(5);
		return player;
	}

	@Override
	//Fail: Go to student parking
	public Player fail(Player player) {
		player.setLoc(2);
		return player;
	}

}
