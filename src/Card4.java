import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Card Description: 
 * Professor Murgolo's CECS 174 Class
 * Play in ECS 302
 * Success: Get 1 learning pt
 * Fail: nothing
 * @author Hieu Tran
 *
 */

public class Card4 extends Card{

	public Card4() {
		name = "Professor Murgolo's CECS 174 Class";
		//no point requirement
		checkReqPts = false;
		//Play in ECS 302
		checkReqLoc = true;
		reqLocation.add(14);
		//initialize image
		try {
			img = ImageIO.read(new File("img/card4.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Override
	//Success: Get 1 learning pts
	public Player win(Player player) {
		player.updateLearningPts(1);
		return player;
	}

	@Override
	//Fail: Nothing happen
	public Player fail(Player player) {
		return player;
	}
	
}
