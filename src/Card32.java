import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * Card Description: 
 * Oral Communication
 * Play in any building not ECS
 * Prerequisites:
 * 3 integrity pts
 * Success: 
 * Get 4 quality pts
 * A chip of choice
 * Fail: Discard 1 game card
 * @author Hieu Tran
 *
 */

public class Card32 extends Card{
	
	public Card32() {
		name = "Oral Communication";
		//Required 3 integrity pts
		checkReqPts = true;
		reqIntegrityPts = 3;
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
			img = ImageIO.read(new File("img/card32.png"));
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
	//Success: Get 4 quality pts, and a chip of choice
	public Player win(Player player) {
		//get 4 qp
		player.updateQP(4);
		//choose 1 point
		Object[] option = {"Learning", "Integrity", "Craft"};
		String input = (String) JOptionPane.showInputDialog(null, "Choose now...",
	            "Choose a point", JOptionPane.PLAIN_MESSAGE, null,
	            option, option[1]);
		if(input.equals("Learning")) {
			player.updateLearningPts(1);
		}
		else if (input.equals("Integrity")) {
			player.updateIntegrityPts(1);
		}
		else { //Craft
			player.updateCraftPts(1);
		}
		return player;
	}

	@Override
	//Fail: Discard 1 game card
	public Player fail(Player player) {
		//player.updateGameCard(-1);
		return player;
	}
	
}
