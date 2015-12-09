import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Card Description: 
 * The Outpost
 * Play in outside space except Forbidden Parking (0, 1, 2, 3, 4, 5, 7, 8, 9, 10)
 * Success: Get 1 pts of your choice
 * Fail: nothing
 * @author sam
 *
 */
public class Card35 extends Card{

	//constructor
		public Card35() {
			name = "The Outpost";
			//no point requirement
			checkReqPts = false;
			//Play in outside
			checkReqLoc = true;
			for(int i = 0; i <= 10; i++) {
				reqLocation.add(i);
			}
			reqLocation.remove(6); //except Forbidden Parking
			//initialize image
			try {
				img = ImageIO.read(new File("img/card35.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	@Override
	//Win: get 1 carft chip
	public Player win(Player player) {
		player.updateCraftPts(1);
		return player;
	}

	@Override
	//Fail: nothing
	public Player fail(Player player) {
		return player;
	}

}