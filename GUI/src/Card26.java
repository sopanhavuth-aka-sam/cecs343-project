import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * Card Description: 
 * Loud Buzzing
 * Play in EAT Room
 * Prerequisites:
 * 3 crafting pts
 * Success: 
 * A chip of choice
 * Fail: Lose 2 quality pts
 * @author Hieu Tran
 *
 */

public class Card26 extends Card {
	
	public Card26() {
		name = "Loud Buzzing";
		//Required 3 crafting pts
		checkReqPts = true;
		reqCraftPts = 3;
		//Play in Computer Lab
		checkReqLoc = true;
		reqLocation.add(18);
		//initialize image
		try {
			img = ImageIO.read(new File("img/card26.png"));
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
	//Fail: Lose 2 quality points
	public Player fail(Player player) {
		player.updateQP(-2);
		return player;
	}
}
