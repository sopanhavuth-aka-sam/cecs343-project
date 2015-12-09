import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * Card Description: 
 * Meet the Dean
 * Play in North (12) or South Hall (13)
 * Prerequisite: 3 learning, 3 craft, and 3 integrity
 * Success: Get 5 QP and draw 1 Game card
 * Fail: discard 1 game card
 * @author sam
 *
 */
public class Card25 extends Card{

	//constructor
	public Card25() {
		name = "Meet the Dean";
		//Prerequisite: 3 learning, 3 craft, and 3 integrity
		checkReqPts = true;
		reqLearningPts = 3;
		reqCraftPts = 3;
		reqIntegrityPts = 3;
		//Play in North (12) or South Hall (15)
		checkReqLoc = true;
		reqLocation.add(12);
		reqLocation.add(15);
		//initialize image
		try {
			img = ImageIO.read(new File("img/card25.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		

	@Override
	//Win: 5 QP, draw 1 game card
	public Player win(Player player) {
		//Get 5 QP
		player.updateQP(5);
		//add draw and add 1 card to hand
		if(player.isHuman()) {
			drawCard();
		}	
		return player;
	}

	@Override
	//Fail: Discard 1 game card from player
	public Player fail(Player player) {
		if(player.isHuman()) {
			discardCard();
		}
		return player;
	}

}