import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Card Description: 
 * Enjoy Nature
 * Play any space outside ECS
 * Success: 
 * Get 1 crafting pts
 * Teleport to Lactation Lounge
 * Fail: none
 * @author Hieu Tran
 *
 */

public class Card38 extends Card{

	public Card38() {
		name = "Enjoying Nature";
		//no requirement
		checkReqPts = false;
		//Play in any space outside ECS
		checkReqLoc = true;
		reqLocation.add(0);
		reqLocation.add(1);
		reqLocation.add(2);
		reqLocation.add(3);
		reqLocation.add(4);
		reqLocation.add(5);
		reqLocation.add(6);
		reqLocation.add(7);
		reqLocation.add(8);
		reqLocation.add(9);
		reqLocation.add(10);
	
		//initialize image
		try {
			img = ImageIO.read(new File("img/card38.png"));
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
	//Success: Get 1 crafting pt1, teleport to Lactation Lounge
	public Player win(Player player) {
		player.updateCraftPts(1);
		player.setLoc(20);
		return player;
	}

	@Override
	//Fail: none
	public Player fail(Player player) {
		return player;
	}
	
}
