import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Card Description: 
 * ENGL 317
 * Play in LA5(8)
 * require: 6 craft
 * Success: Get 5 QP
 * Fail: go to student parking (2)
 * @author sam
 *
 */
public class Card44 extends Card{
	
	//constructor
	public Card44() {
		name = "ENGL 317";
		//no point requirement
		checkReqPts = true;
		reqCraftPts = 6;
		//Play in LA5(8)
		checkReqLoc = true;
		reqLocation.add(8);
		//initialize image
		try {
			img = ImageIO.read(new File("img/card44.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	//Win: Get 5 QP
	public Player win(Player player) {
		player.updateQP(5);;
		return player;
	}

	@Override
	//Fail: go to student parking(2)
	public Player fail(Player player) {
		player.setLoc(2);
		return player;
	}

}
