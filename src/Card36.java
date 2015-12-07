import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

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
		//get 3 qp
		player.updateQP(3);
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
	//Fail: Lose 1 quality pt
	public Player fail(Player player) {
		player.updateQP(-1);
		return player;
	}

}
