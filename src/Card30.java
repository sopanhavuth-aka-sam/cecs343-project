import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Card Description: 
 * Soccer Goalie
 * Play in George Allen Field
 * Prerequisites:
 * 3 learning pts
 * 3 craft pts
 * Success: 
 * Get 5 quality pts
 * Get 1 game card
 * Fail: Go to student parking
 * @author Hieu Tran
 *
 */

public class Card30 extends Card {

	public Card30() {
		name = "Soccer Goalie";
		//Required 3 learning pts, 3 craft pts
		checkReqPts = true;
		reqLearningPts = 3;
		reqCraftPts = 3;
		//Play in George Allen Field
		checkReqLoc = true;
		reqLocation.add(0);
		//initialize image
		try {
			img = ImageIO.read(new File("img/card30.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Override
	//Success: Get 5 quality pts, 1 game card
	public Player win(Player player) {
		//Get 5 QP
		player.updateQP(5);
		//add draw and add 1 card to hand
		hand.addCard(deck.deal());
		return player;
	}

	@Override
	//Fail: Go to student parking
	public Player fail(Player player) {
		player.setLoc(2);
		return player;
	}
}
