import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Card Description: 
 * CECS 274
 * Play in ECS 302(14), 308(17), lab (11)
 * require: 7 learning
 * Success: Get 5 QP, 1 game card
 * Fail: Lose 3 QP
 * @author sam
 *
 */
public class Card42 extends Card{
	
	//constructor
	public Card42() {
		name = "CECS 274";
		//no point requirement
		checkReqPts = true;
		reqLearningPts = 7;
		//Play in ECS 302(14), 308(17), lab(11)
		checkReqLoc = true;
		reqLocation.add(14);
		reqLocation.add(17);
		reqLocation.add(11);
		//initialize image
		try {
			img = ImageIO.read(new File("img/card42.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	//Win: Get 5 QP, 1 game card
	public Player win(Player player) {
		player.updateQP(5);
		//add draw and add 1 card to hand
		if(player.isHuman()) {
			drawCard();
		}
		return player;
	}

	@Override
	//Fail: Lose 3 QP
	public Player fail(Player player) {
		player.updateQP(-3);
		return player;
	}

}