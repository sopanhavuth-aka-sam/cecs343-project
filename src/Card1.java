import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Card Description: 
 * CECS 105
 * Play in ECS 302(14) or 308(17)
 * Success: Get 1 learning pts
 * Fail: nothing
 * @author sam
 *
 */
public class Card1 extends Card{
	
	//constructor
	public Card1() {
		name = "CECS 105";
		//no point requirement
		checkReqPts = false;
		//Play in ECS 302(14) or 308(17)
		checkReqLoc = true;
		reqLocation.add(14);
		reqLocation.add(17);
		//initialize image
		try {
			img = ImageIO.read(new File("img/card1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	//Win: Get 1 learning pts
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
