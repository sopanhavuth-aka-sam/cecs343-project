import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Card Description: 
 * Student Parking
 * Play Student Parking (2)
 * Success: get 1 craft pts and go to lactation lounge (20)
 * Fail: nothing
 * @author sam
 *
 */
public class Card39 extends Card{

	//constructor
	public Card39() {
		name = "Student Parking";
		//no point prereq
		checkReqPts = false;
		//Play Student Parking (2)
		checkReqLoc = true;
		reqLocation.add(2);
		//initialize image
		try {
			img = ImageIO.read(new File("img/card39.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	//Win: get 1 craft chip; move to lactation lounge(20)
	public Player win(Player player) {
		player.updateCraftPts(1);
		player.setLoc(20);
		return player;
	}

	@Override
	//Fail: nothing
	public Player fail(Player player) {
		return player;
	}

}