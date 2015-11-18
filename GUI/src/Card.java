import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Card {

	protected String name;
	protected boolean checkReqPts;
	protected int reqLearningPts = 0, reqCraftPts = 0, reqIntegrityPts = 0;
	protected int discard = 0;
	protected ArrayList<Integer> reqLocation = new ArrayList<Integer>();
	protected boolean checkReqLoc;
	protected BufferedImage img;
	
	/**
	 * 
	 * @param player
	 * @return
	 */
	public Player play(Player player) {
		//boolean for passing Point req and Location req
		boolean passPts = false, passLoc = false;
		//points and location validation: this determine if the play is successes
		//or fail
		if(checkReqPts) {
			passPts = validatePts(player);
		}
		else {
			passPts = true;
		}
		if(checkReqLoc) {
			passLoc = validateLoc(player);
		}
		else {
			passLoc = true;
		}
		//calling win() or fail() method base on "result"
		if(passPts && passLoc) {
			return win(player);
		}
		else {
			return fail(player);
		}
	}
	
	/**
	 * 
	 * @param player
	 * @return
	 */
	public abstract Player win(Player player);
	
	/**
	 * 
	 * @param player
	 * @return
	 */
	public abstract Player fail(Player player);
	
	/**
	 * 
	 * @param player
	 * @return
	 */
	public boolean validatePts(Player player) {
		if(player.getLearningPts() >= reqLearningPts) {
			if(player.getCraftPts() >= reqCraftPts) {
				if(player.getIntegrityPts() >= reqIntegrityPts) {
					System.out.println("check pts");
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	/*
	public boolean discardCard(Player player){
		if (player.getDiscard() >= discard){
			return true;
		}
		
		return false;
	}
	*/
	
	/**
	 * 
	 * @param player
	 * @return
	 */
	public boolean validateLoc(Player player) {
		for(int i = 0; i < reqLocation.size(); i++) {
			if (player.getLoc() == reqLocation.get(i)) {
				return true;
			}
		}
		return false;
	}
	
	public Image getImg() {
		return img;
	}
}