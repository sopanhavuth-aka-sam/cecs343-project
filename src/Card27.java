import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * Card Description: 
 * Program Crashes
 * Play in Lactation Lounge (20)
 * Prerequisite: 2 learning
 * Success: Get 5 QP and 1 pts of your choice
 * Fail: discard 1 game card
 * @author sam
 *
 */
public class Card27 extends Card{

	//constructor
		public Card27() {
			name = "Program Crashes";
			//Prerequisite: 2 learning
			checkReqPts = true;
			reqLearningPts = 2;
			//Play in Lactation Lounge (20)
			checkReqLoc = true;
			reqLocation.add(20);
			//initialize image
			try {
				img = ImageIO.read(new File("img/card27.png"));
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
		//get 5 qp
		player.updateQP(5);
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
	//Fail: Discard 1 game card from player
	public Player fail(Player player) {
		return player;
	}

}