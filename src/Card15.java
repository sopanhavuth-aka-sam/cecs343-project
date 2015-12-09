import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Card Description: 
 * The Big Game
 * Play in the Pyramid (3)
 * Success: Get 1 Craft pts, Move to Lactation Lounge (20)
 * Fail: nothing
 * @author sam
 *
 */
public class Card15 extends Card{

	//constructor
		public Card15() {
			name = "The Big Game";
			//no point requirement
			checkReqPts = false;
			//Play in outside
			checkReqLoc = true;
			reqLocation.add(3);
			//initialize image
			try {
				img = ImageIO.read(new File("img/card15.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	@Override
	//Win: get 1 craft chip and move to lacation lounge(20)
	public Player win(Player player) {
		player.updateCraftPts(1);
		player.setLoc(20);
		return player;
	}

	@Override
	//Fail: Nothing happen
	public Player fail(Player player) {
		return player;
	}

}