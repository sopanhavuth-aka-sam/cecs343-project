import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Card Description: 
 * Score a Goal!
 * Play in George Allen Field (0)
 * Prerequisite: 3 craft
 * Success: Get 5 QP and 1 integrity
 * Fail: go to student parking (2)
 * @author sam
 *
 */
public class Card21 extends Card{

	//constructor
		public Card21() {
			name = "Score a Goal!";
			//Prerequisite: 3 craft
			checkReqPts = true;
			reqCraftPts = 3;
			//Play in George Allen Field (0)
			checkReqLoc = true;
			reqLocation.add(0);
			//initialize image
			try {
				img = ImageIO.read(new File("img/card21.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	@Override
	//Win: get 5 QP and 1 integrity chip
	public Player win(Player player) {
		player.updateQP(5);
		player.updateIntegrityPts(1);
		return player;
	}

	@Override
	//Fail: go to student parking(2)
	public Player fail(Player player) {
		player.setLoc(2);
		return player;
	}

}