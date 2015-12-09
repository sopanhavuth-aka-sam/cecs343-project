import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * Card Description: 
 * CECS 282
 * Play in any room in ECS
 * require: 8 Learning, 8 Craft, and 8 Integrity
 * Success: Get 5 QP
 * Fail: Lose 2 QP, and discard 1 game card
 * @author sam
 *
 */
public class Card50 extends Card{
	
	//constructor
	public Card50() {
		name = "CECS 282";
		//requirement 8 learning, 8 craft, and 8 integrity
		checkReqPts = true;
		reqLearningPts = 8;
		reqCraftPts = 8;
		reqIntegrityPts = 8;
		//Play in any room in ECS
		checkReqLoc = true;
		reqLocation.add(11);
		reqLocation.add(12);
		reqLocation.add(13);
		reqLocation.add(14);
		reqLocation.add(15);
		reqLocation.add(16);
		reqLocation.add(17);
		reqLocation.add(18);
		reqLocation.add(19);
		reqLocation.add(20);
		//initialize image
		try {
			img = ImageIO.read(new File("img/card50.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	//Win: Get 5 QP
	public Player win(Player player) {
		player.updateQP(5);
		return player;
	}

	@Override
	//Fail: Lose 2 QP, and discard 1 game card
	public Player fail(Player player) {
		player.updateQP(-2);
		//discard 1 card
		if(player.isHuman()) {
			discardCard();
		}
		return player;
	}

}