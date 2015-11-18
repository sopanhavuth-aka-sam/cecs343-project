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
	public Player play(Player player) {
		//boolean flag identifying if the play successes or fail
		boolean result = false;
		//points and location validation: this determine if the play is successes
		//or fail
		if(checkReqPts) {
			result = validatePts(player);
		}
		if(checkReqLoc) {
			result = validateLoc(player);
		}
		//calling win() or fail() method base on "result"
		if(result) {
			return win(player);
		}
		else {
			return fail(player);
		}
	}

	@Override
	public Player win(Player player) {
		player.updateCraftPts(1);
		player.setLoc(2);
		return player;
	}

	@Override
	public Player fail(Player player) {
		return player;
	}

}