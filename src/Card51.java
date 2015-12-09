import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;


/**
 * Card Description: 
 * Have A Swim
 * Play in Student Recreation
 * Success: Get a chip of choice
 * Fail: nothing
 * @author sam
 *
 */
public class Card51 extends Card{
	
	//constructor
	public Card51() {
		name = "CECS 105";
		//no point requirement
		checkReqPts = false;
		//Play in Student Recreation
		checkReqLoc = true;
		reqLocation.add(5);
		//initialize image
		try {
			img = ImageIO.read(new File("img/card51.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	//Win: Get 1 learning pts
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
	//Fail: Nothing happen
	public Player fail(Player player) {
		return player;
	}

}