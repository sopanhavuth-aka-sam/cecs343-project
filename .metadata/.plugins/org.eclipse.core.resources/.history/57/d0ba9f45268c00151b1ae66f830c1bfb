import java.awt.Image;
import java.util.ArrayList;

public abstract class Card {

	protected String name;
	protected boolean checkReqPts;
	protected int reqLearningPts = 0, reqCraftPts = 0, reqIntegrityPts = 0;
	protected ArrayList<Integer> reqLocation = new ArrayList<Integer>();
	protected boolean checkReqLoc;
	protected Image img; //card image
	//protected int rewardLearning, rewardCraft, rewardIntegrity, rewardQP;
	//protected int failLearning, failCraft, failIntegrity, failQP;
	//protected boolean moveLoc;
	//protected int newLoc;
	
	/**
	 * 
	 * @param player
	 * @return
	 */
	public abstract Player play(Player player);
	
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