import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * Card Description: 
 * Goodbye, Professor
 * Play in Room of Retirement
 * Prerequisites:
 * 6 learning pts
 * 6 crafting pts
 * 6 integrity pts
 * Success: 
 * Get 10 quality pts
 * Fail: 
 * Lose 1 game card
 * Leave this game card in RoR
 * @author Hieu Tran
 *
 */

public class Card10 extends Card{

	public Card10() {
		name = "Goodbye, Professor";
		//required 6 learning pts, 6 crafting pts, 6 integrity pts
		checkReqPts = true;
		reqLearningPts = 6;
		reqCraftPts = 6;
		reqIntegrityPts = 6;
		//Play in Room of Retirement
		checkReqLoc = true;
		reqLocation.add(13);
		
		//initialize image
		try {
			img = ImageIO.read(new File("img/card10.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	//Win: Get 10 quality pts
	public Player win(Player player) {
		player.updateQP(10);
		return player;
	}

	@Override
	//Fail: Lose 1 game card
	public Player fail(Player player) {
		if(player.isHuman()) {
			discardCard();
		}
		return player;
	}
	
}
