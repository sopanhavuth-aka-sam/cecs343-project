import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Card Description: 
 * Make the Dean's List
 * Play in North (12) or South Halls (15)
 * Prerequisite: 6 Learning
 * Success: Get 5 QP
 * Fail: got to student parking (2)
 * @author sam
 *
 */
public class Card23 extends Card{

	//constructor
		public Card23() {
			name = "Make the Dean's List";
			//Prerequisite: 6 Learning
			checkReqPts = true;
			reqLearningPts = 6;
			//Play in North (12) or South Halls (15)
			checkReqLoc = true;
			reqLocation.add(12);
			reqLocation.add(15);
			//initialize image
			try {
				img = ImageIO.read(new File("img/card23.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	@Override
	//Win: get 5 QP
	public Player win(Player player) {
		player.updateQP(5);
		return player;
	}

	@Override
	//Fail: go to student parking (2)
	public Player fail(Player player) {
		player.setLoc(2);
		return player;
	}

}