import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * Card Description: 
 * CECS 285
 * Play in EAT Room or Japanese Garden
 * require: 6 Learning
 * Success: Get 5 QP, and a chip of choice
 * Fail: Lose 3 QP
 * @author sam
 *
 */
public class Card49 extends Card{
	
	//constructor
	public Card49() {
		name = "CECS 285";
		//requirement 6 learning
		checkReqPts = true;
		reqLearningPts = 6;
		//Play in EAT Room or Japanese Garden
		checkReqLoc = true;
		reqLocation.add(1);
		reqLocation.add(18);
		//initialize image
		try {
			img = ImageIO.read(new File("img/card49.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	//Win: Get 5 QP, and a chip of choice
	public Player win(Player player) {
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
	//Fail: Lose 3 QP
	public Player fail(Player player) {
		player.updateQP(-3);
		return player;
	}

}