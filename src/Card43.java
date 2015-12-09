import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * Card Description: 
 * CECS 201
 * Play in ECS 302(14), 308(17), lab(11)
 * require: 8 craft pts
 * Success: Get 1 learning, 1 craft, 1 integrity pts
 * Fail: Lose 3 QP, and discard 1 game card
 * @author sam
 *
 */
public class Card43 extends Card{
	
	//constructor
	public Card43() {
		name = "CECS 201";
		//no point requirement
		checkReqPts = true;
		reqCraftPts = 8;
		//Play in ECS 302(14) or 308(17) or lab(11)
		checkReqLoc = true;
		reqLocation.add(14);
		reqLocation.add(17);
		reqLocation.add(11);
		//initialize image
		try {
			img = ImageIO.read(new File("img/card43.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	//Win: Get 1 learning, 1 craft, 1 integrity pts
	public Player win(Player player) {
		player.updateLearningPts(1);
		player.updateIntegrityPts(1);
		player.updateCraftPts(1);
		return player;
	}

	@Override
	//Fail: Lose 3 QP, and discard 1 game card
	public Player fail(Player player) {
		player.updateQP(-3);
		//discard 1 card
		if(player.isHuman()) {
			discardCard();
		}
		return player;
	}

}
