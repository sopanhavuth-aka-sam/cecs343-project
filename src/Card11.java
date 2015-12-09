import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * Card Description: 
 * Enjoying the Peace
 * Play in Japanese Gardens (1)
 * Success: get 1 learning pts or 1 integrity pts
 * @author sam
 *
 */
public class Card11 extends Card{

	//constructor
		public Card11() {
			name = "Enjoying the Peace";
			//no pts requirement
			checkReqPts = false;
			//Play in Japanese Gardens (1)
			checkReqLoc = true;
			reqLocation.add(1);
			//initialize image
			try {
				img = ImageIO.read(new File("img/card11.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	@Override
	//Win: choose 1 learning or integrity chip
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

	@Override
	//Fail: nothing
	public Player fail(Player player) {
		return player;
	}

}