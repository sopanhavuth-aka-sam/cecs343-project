import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Card Description: In Progress
 * PHIL 270
 * Play in LA5(8) or Library(7)
 * require: 7 integrity
 * Success: Get 3 QP and 1 learning chip
 * Fail: lose 3 QP
 * @author sam
 *
 */
public class Card46 extends Card{
	
	//constructor
	public Card46() {
		name = "PHIL 270";
		//no point requirement
		checkReqPts = true;
		reqIntegrityPts = 7;
		//Play in LA5(8) or Library(7)
		checkReqLoc = true;
		reqLocation.add(8);
		reqLocation.add(7);
		//initialize image
		try {
			img = ImageIO.read(new File("img/card46.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	//Win: Get 3 QP and 1 learning chip
	public Player win(Player player) {
		player.updateQP(3);
		player.updateLearningPts(1);
		return player;
	}

	@Override
	//Fail: Lose 3 QP
	public Player fail(Player player) {
		player.updateQP(-3);
		return player;
	}

}
