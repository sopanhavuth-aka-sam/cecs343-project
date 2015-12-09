import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * Card Description: 
 * Math 123
 * Play in ECS 302 (14) or 308 (17)
 * Require Point: 5 learning
 * Success: get 5 QP
 * Fail: lose 3 QP and lose 1 game card
 * @author sam
 *
 */
public class Card17 extends Card{

	//constructor
	public Card17() {
		name = "Math 123";
		//require: 5 learning
		checkReqPts = true;
		reqCraftPts = 5;
		//Play in ECS 302 (14) or 308 (17)
		checkReqLoc = true;
		reqLocation.add(14);
		reqLocation.add(17);
		//initialize image
		try {
			img = ImageIO.read(new File("img/card17.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		

	//Win: get 5 Quality points
	@Override
	public Player win(Player player) {
		player.updateQP(5);
		return player;
	}

	//Fail: lose 3 Quality points; discard a card
	@Override
	public Player fail(Player player) {
		player.updateQP(-3);
		if(player.isHuman()) {
			discardCard();
		}
		return player;
	}

}