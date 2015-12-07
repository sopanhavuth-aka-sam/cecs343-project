import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Card Description: 
 * KIN 253
 * Learning the Rules of Soccer
 * Play in George Allen Field
 * Prerequisites:
 * 4 integrity pts
 * Success: 
 * Get 2 crafting pts
 * Fail: Go to Room of Retirement
 * @author Hieu Tran
 *
 */

public class Card16 extends Card{

	public Card16() {
		name = "KIN 253";
		//required 4 integrity pts
		checkReqPts = true;
		reqIntegrityPts = 4;
		//Play in ECS 308
		checkReqLoc = true;
		reqLocation.add(0);
		
		//initialize image
		try {
			img = ImageIO.read(new File("img/card16.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	//Success: Get 2 crafting pts
	public Player win(Player player) {
		player.updateCraftPts(2);
		return player;
	}

	@Override
	//Fail: Go to Room of Retirement
	public Player fail(Player player) {
		player.setLoc(13);
		return player;
	}
	
}
