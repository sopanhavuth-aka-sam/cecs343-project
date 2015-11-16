import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Card Description: 
 * Research Compilers
 * Play in the Library
 * Success: Get 1 learning pt
 * Fail: nothing
 * @author Hieu Tran
 *
 */

public class Card2 extends Card{
	
	public Card2() {
		name = "Research Compilers";
		//no point requirement
		checkReqPts = false;
		//Play in Library
		checkReqLoc = true;
		reqLocation.add(7);
		//initialize image
		try {
			img = ImageIO.read(new File("/img/card2.png"));
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