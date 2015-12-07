import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * Card Description: 
 * A New Laptop
 * Play in Computer Lab
 * Prerequisites:
 * 4 integrity pts
 * Success: 
 * Get 3 quality pts
 * A chip of choice
 * Fail: Discard 1 game card
 * @author Hieu Tran
 *
 */

public class Card24 extends Card{
	
	public Card24() {
		name = "A New Laptop";
		//Required 4 integrity pts
		checkReqPts = true;
		reqIntegrityPts = 4;
		//Play in Computer Lab
		checkReqLoc = true;
		reqLocation.add(11);
		//initialize image
		try {
			img = ImageIO.read(new File("img/card24.png"));
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
	//Fail: Discard 1 game card
	public Player fail(Player player) {
		//player.updateGameCard(-1);
		return player;
	}
}
