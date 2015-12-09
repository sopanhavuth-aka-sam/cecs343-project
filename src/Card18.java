import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Card Description: 
 * Learning Netbeans
 * Play in Lactation Lounge
 * Prerequisites:
 * 3 learning pts
 * Success: 
 * Get 5 quality pts
 * Fail: Lose 3 quality pts
 * @author Hieu Tran
 *
 */

public class Card18 extends Card {

	public Card18() {
		name = "Learning Netbeans";
		//Required 3 learning pts
		checkReqPts = true;
		reqLearningPts = 3;
		//Play in Lactation Lounge
		checkReqLoc = true;
		reqLocation.add(20);
		//initialize image
		try {
			img = ImageIO.read(new File("img/card18.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	//Success: Get 5 quality pts
	public Player win(Player player) {
		player.updateQP(5);
		return player;
	}

	@Override
	//Fail: Lose 3 quality points
	public Player fail(Player player) {
		player.updateQP(-3);
		return player;
	}
	
}
