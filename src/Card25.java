import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Card Description: 
 * A New Laptop
 * Play in Computer Lab (11)
 * Prerequisite: 4 Integrity
 * Success: Get 3 QP, get one point of your choice
 * Fail: discard 1 game card
 * @author sam
 *
 */
public class Card25 extends Card{

	//constructor
		public Card25() {
			name = "A New Laptop";
			//Prerequisite: 4 Integrity
			checkReqPts = true;
			reqIntegrityPts = 4;
			//Play in Computer Lab (11)
			checkReqLoc = true;
			reqLocation.add(11);
			//initialize image
			try {
				img = ImageIO.read(new File(""));
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
		player.updateQP(3);
		//let user choose a point of their choice
		//player.update...
		return player;
	}

	@Override
	//Fail: Discard a game card
	//NEED: Implement function for player to discard a card
	public Player fail(Player player) {
		return player;
	}

}