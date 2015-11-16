import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Card Description: 
 * Professor Murgolo's CECS 174 Class
 * Play in ECS 302
 * Success: Get 1 learning pt
 * Fail: nothing
 * @author Hieu Tran
 *
 */

public class Card4 extends Card{

	public Card4() {
		name = "Professor Murgolo's CECS 174 Class";
		//no point requirement
		checkReqPts = false;
		//Play in ECS 302
		checkReqLoc = true;
		reqLocation.add(14);
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
	//Success: Get 1 learning pts
	public Player win(Player player) {
		player.updateLearningPts(1);
		return player;
	}

	@Override
	//Fail: Nothing happen
	public Player fail(Player player) {
		return player;
	}
	
}
