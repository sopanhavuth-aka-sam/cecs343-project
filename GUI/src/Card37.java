import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * Card Description: 
 * Make a Friend
 * Play in North (12) or South Hall (15) 
 * Prerequisite: 2 integrity
 * Success: get 3 QP and a pts of your choice
 * Fail: discard 1 game card
 * @author sam
 *
 */
public class Card37 extends Card{

	//constructor
	public Card37() {
		name = "Make a Friend";
		//Prerequisite: 2 integrity
		checkReqPts = true;
		reqIntegrityPts = 2;
		//Play in outside
		checkReqLoc = true;
		reqLocation.add(12);
		reqLocation.add(15);
		//initialize image
		try {
			img = ImageIO.read(new File("img/card37.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
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
	public Player fail(Player player) {
		//Discard 1 game card
		return player;
	}

}