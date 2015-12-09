import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Card Description: 
 * CECS 100
 * Play in ECS 308
 * Success: Get 1 crafting pts
 * Fail: nothing
 * @author Hieu Tran
 *
 */

public class Card6 extends Card{

	public Card6() {
		name = "CECS 100";
		//no point requirement
		checkReqPts = false;
		//Play in ECS 308
		checkReqLoc = true;
		reqLocation.add(17);
		//initialize image
		try {
			img = ImageIO.read(new File("img/card6.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Override
	//Success: Get 1 craft chip
	public Player win(Player player) {
		player.updateCraftPts(1);
		return player;
	}

	@Override
	//Fail: Nothing happen
	public Player fail(Player player) {
		return player;
	}
	
}
