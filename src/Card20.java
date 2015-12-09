import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Card Description: 
 * Pass Soccer Class
 * Play in George Allen Field
 * Prerequisites:
 * 5 crafting pts
 * Success: 
 * Get 5 quality pts
 * Fail: Lose 3 quality pts
 * @author Hieu Tran
 *
 */

public class Card20 extends Card{
	
	public Card20() {
		name = "Pass Soccer Class";
		//Required 5 crafting pts
		checkReqPts = true;
		reqLearningPts = 5;
		//Play in George Allen Field
		checkReqLoc = true;
		reqLocation.add(0);
		//initialize image
		try {
			img = ImageIO.read(new File("img/card20.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	//Win: Get 5 quality pts
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
