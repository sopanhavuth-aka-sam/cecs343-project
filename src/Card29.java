import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Card Description: 
 * Press the Right Floor
 * Play in Elevators (16)
 * Prerequisite: 4 learning
 * Success: Get 2 craft pts
 * Fail: lose 2 quality pts
 * @author sam
 *
 */
public class Card29 extends Card{

	//constructor
		public Card29() {
			name = "Press the Right Floor";
			//Prerequisite: 4 learning
			checkReqPts = true;
			reqLearningPts = 4;
			//Play in Play in Elevators (16)
			checkReqLoc = true;
			reqLocation.add(19);
			//initialize image
			try {
				img = ImageIO.read(new File("img/card29.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	@Override
	//Win: get 2 craft chips
	public Player win(Player player) {
		player.updateCraftPts(2);
		return player;
	}

	@Override
	//Fail: lose 2 QP
	public Player fail(Player player) {
		player.updateQP(-2);
		return player;
	}

}