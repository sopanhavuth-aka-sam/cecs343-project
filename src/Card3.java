import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * Card Description: 
 * Math 122
 * Play in library(7)
 * Success: Get 1 learning pts or get 1 integrity chip
 * Fail: nothing
 * @author sam
 *
 */
public class Card3 extends Card{

	//constructor
		public Card3() {
			name = "Math 122";
			//no point requirement
			checkReqPts = false;
			//Play in library(7)
			checkReqLoc = true;
			reqLocation.add(7);
			//initialize image
			try {
				img = ImageIO.read(new File("img/card3.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	@Override
	//Win: 1 learning or integrity chip
	public Player win(Player player) {
		Object[] option = {"Learning", "Integrity"};
	    String input = (String) JOptionPane.showInputDialog(null, "Choose now...",
	            "Choose a point", JOptionPane.PLAIN_MESSAGE, null,
	            option, option[1]);
		if(input.equals("Learning")) {
			player.updateLearningPts(1);
		}
		else{
			player.updateIntegrityPts(1);
		}
		return player;
	}

	//Fail: nothing
	@Override
	public Player fail(Player player) {
		return player;
	}

}
