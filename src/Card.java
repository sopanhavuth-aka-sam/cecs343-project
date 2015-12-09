import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public abstract class Card {

	protected String name;
	protected boolean checkReqPts;
	protected int reqLearningPts = 0, reqCraftPts = 0, reqIntegrityPts = 0;
	protected ArrayList<Integer> reqLocation = new ArrayList<Integer>();
	protected boolean checkReqLoc;
	protected BufferedImage img;
	protected Model model;
//	protected Hand hand = model.playerHand;
//	protected Deck deck = model.deck;
	
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
	
	/**
	 * 
	 * @param player
	 * @return
	 */
	public boolean validateLoc(Player player) {
		for(int i = 0; i < reqLocation.size(); i++) {
			if (player.getLoc() == reqLocation.get(i)) {
				System.out.println("check location");
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @return
	 */
	public Image getImg() {
		return img;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Integer> getReqLoc() {
		return reqLocation;
	}
	
	/**
	 * 
	 */
	public void discardCard() {
		try {
			Hand hand = Model.playerHand;
		    //create arraylist of cardName in the hand; excluding this card
		    ArrayList<String> cardName = new ArrayList<String>();
		    for (int i = 0; i < hand.size(); i++) {
		        if(!name.equals(hand.getCard(i).getName())){
		            cardName.add(hand.getCard(i).getName());
		        }
		    }
		    //convert arraylist of cardName into array Object[]
		    Object[] option = cardName.toArray();
		    String input = (String) JOptionPane.showInputDialog(null, "Choose now...",
		            "Choose a card to discard", JOptionPane.PLAIN_MESSAGE, null,
		            option, option[1]);
		    //remove card(input) from hand
		    for (int i = 0; i < hand.size(); i++) {
		        if(hand.getCard(i).getName().equals(input)) {
		            Model.playerHand.removeCard(i);//use Model not the local copy(hand)
		        }
		    }
		    //DEBUG: PRINT OUT
		    System.out.println("Card Discarded");
		} catch(NullPointerException e) {
		    System.out.println(e);
		}
	}
	/**
	 * 
	 */
	public void drawCard() {
		try {
			Model.playerHand.addCard(Model.deck.deal());
			//DEBUG: PRINT OUT
			System.out.println("Card was draw");
		} catch(NullPointerException e) {
		    System.out.println(e);
		}
	}
}