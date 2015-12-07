import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * Card Description: 
 * LBSU vs UCI
 * Play in Pyramid (3)
 * Success: Get 1 of your choice
 * Fail: nothing
 * @author sam
 *
 */
public class Card40 extends Card{
	
	//constructor
	public Card40() {
		name = "LBSU vs UCI";
		//no point requirement
		checkReqPts = false;
		//Play in Pyramid (3)
		checkReqLoc = true;
		reqLocation.add(3);
		//initialize image
		try {
			img = ImageIO.read(new File("img/card40.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	//Win: Get 1 chip of your choice
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