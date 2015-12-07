import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Card Description: 
 * Finding the Lab
 * Play in Elevators (16)
 * Success: Get 1 Integrity pts
 * Fail: nothing
 * @author sam
 *
 */
public class Card9 extends Card{

	//constructor
		public Card9() {
			name = "Finding the Lab";
			//no point requirement
			checkReqPts = false;
			//Play in Elevators (16)
			checkReqLoc = true;
			reqLocation.add(16);
			//initialize image
			try {
				img = ImageIO.read(new File("img/card9.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	@Override
	//Win: Get 1 integrity chip
	public Player win(Player player) {
		player.updateIntegrityPts(1);
		return player;
	}

	@Override
	//Fail: Nothing happen
	public Player fail(Player player) {
		return player;
	}

}