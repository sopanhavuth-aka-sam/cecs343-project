import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * Card Description: 
 * Buddy Up
 * Join EAT or Soccer Team
 * Play in EAT room or George Allen Field
 * Success: 
 * Get 1 learning pt or 1 crafting pt
 * Fail: nothing
 * @author Hieu Tran
 *
 */

public class Card12 extends Card {
	
	public Card12() {
		name = "Join EAT or Soccer Team";
		//no point requirement
		checkReqPts = false;
		//Play in EAT Room or George Allen Field
		checkReqLoc = true;
		reqLocation.add(18);
		reqLocation.add(0);
		//initialize image
		try {
			img = ImageIO.read(new File("img/card12.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	//Win: choose 1 learning or craft chip
	public Player win(Player player) {
		Object[] option = {"Learning", "Craft"};
		String input = (String) JOptionPane.showInputDialog(null, "Choose now...",
	            "Choose a point", JOptionPane.PLAIN_MESSAGE, null,
	            option, option[1]);
		if(input.equals("Learning")) {
			player.updateLearningPts(1);
		}
		else{
			player.updateCraftPts(1);
		}
		return player;
	}

	@Override
	//Fail: nothing
	public Player fail(Player player) {
		return player;
	}
	
}
