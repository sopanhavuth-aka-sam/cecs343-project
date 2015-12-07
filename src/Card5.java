import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Card Description: 
 * Lunch at Bratwurst Hall
 * Play in Bratwurst Hall (9)
 * Success: Get 1 Craft pts
 * Fail: nothing
 * @author sam
 *
 */
public class Card5 extends Card{

	//constructor
		public Card5() {
			name = "Lunch at Bratwurst Hall";
			//no point requirement
			checkReqPts = false;
			//Play in Bratwurst Hall (9)
			checkReqLoc = true;
			reqLocation.add(9);
			//initialize image
			try {
				img = ImageIO.read(new File("img/card5.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	@Override
	//Win: Get 1 craft chip
	public Player win(Player player) {
		player.updateCraftPts(1);;
		return player;
	}

	@Override
	//Fail: Nothing happen
	public Player fail(Player player) {
		return player;
	}

}