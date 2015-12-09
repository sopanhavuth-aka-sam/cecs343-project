import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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


	@Override
	//Win: Get 4 quality pts, and a chip of choice
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
		if(player.isHuman()) {
			discardCard();
		}
		return player;
	}
	
}
