import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * Card Description: 
 * PHYS 152
 * Play in LA5(8) or Library(7)
 * require: 7 integrity
 * Success: get 5 QP and 1 chip of your choice
 * Fail: Discard 1 card
 * @author sam
 *
 */
public class Card45 extends Card{
	
	//constructor
	public Card45() {
		name = "PHYS 152";
		//no point requirement
		checkReqPts = true;
		reqIntegrityPts = 7;
		//Play in LA5(8) or Library(7)
		checkReqLoc = true;
		reqLocation.add(8);
		reqLocation.add(7);
		//initialize image
		try {
			img = ImageIO.read(new File("img/card45.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	//Win: get 5 QP and a chip of your choice
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
	//Fail: Discard 1 card
	public Player fail(Player player) {
		//discard 1 card
		//discard 1 card
		if(player.isHuman()) {
			discardCard();
		}
		return player;
	}

}
