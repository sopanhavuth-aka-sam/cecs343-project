import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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

	@Override
	//Win: get 3 QP and choose 1 chips
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
		if(player.isHuman()) {
			discardCard();
		}
		return player;
	}
}
