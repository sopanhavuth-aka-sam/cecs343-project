import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Card Description: 
 * Choosing a Major
 * Play in CECS Conference (19)
 * Requirement: 3 Integrity
 * Success: Get 5 QP
 * Fail: Lose 3 QP
 * @author sam
 *
 */
public class Card19 extends Card{

	//constructor
		public Card19() {
			name = "Choosing a Major";
			//Req: 3 integrity
			checkReqPts = true;
			reqIntegrityPts = 3;
			//Play in CECS Conference (19)
			checkReqLoc = true;
			reqLocation.add(19);
			//initialize image
			try {
				img = ImageIO.read(new File("img/card19.png"));
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
	//Fail: lose 3 QP
	public Player fail(Player player) {
		player.updateQP(-3);
		return player;
	}

}