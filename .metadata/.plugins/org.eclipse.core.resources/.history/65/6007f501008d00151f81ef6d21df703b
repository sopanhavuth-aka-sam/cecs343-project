import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Card Description: 
 * Goodbye, Professor
 * Play in Room of Retirement
 * Prerequisites:
 * 6 learning pts
 * 6 crafting pts
 * 6 integrity pts
 * Success: 
 * Get 10 quality pts
 * Fail: 
 * Lose 1 game card
 * Leave this game card in RoR
 * @author Hieu Tran
 *
 */

public class Card10 extends Card{

	public Card10() {
		name = "Goodbye, Professor";
		//required 6 learning pts, 6 crafting pts, 6 integrity pts
		checkReqPts = true;
		reqLearningPts = 6;
		reqCraftPts = 6;
		reqIntegrityPts = 6;
		//Play in Room of Retirement
		checkReqLoc = true;
		reqLocation.add(13);
	}
	
	public Image getImage(Object name){
		//initialize image
		try {
			img = ImageIO.read(new File("img/card1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
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
	//Success: Get 10 quality pts
	public Player win(Player player) {
		player.updateQP(10);
		return player;
	}

	@Override
	//Fail: Lose 1 game card, and leave it in RoR
	public Player fail(Player player) {
		//player.getDiscard(-1);
		return player;
	}
	
}
