import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Card Description: 
 * Physics 151
 * Play in ECS 308
 * Prerequisites:
 * 3 crafting pts
 * Success: 
 * Get 5 quality pts
 * Fail: Lose 3 quality pts
 * @author Hieu Tran
 *
 */

public class Card14 extends Card{

	public Card14() {
		name = "Physics 151";
		//required 3 crafting pts
		checkReqPts = true;
		reqCraftPts = 3;
		//Play in ECS 308
		checkReqLoc = true;
		reqLocation.add(17);
		
		//initialize image
		try {
			img = ImageIO.read(new File("img/card14.png"));
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
	//Fail: Lose 3 quality pts
	public Player fail(Player player) {
		player.updateQP(-3);
		return player;
	}
}
