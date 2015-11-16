import java.util.ArrayList;

public class Hand {
	
	private ArrayList<Card> hand;
	private int size;
	
	public Hand(){
		hand = new ArrayList<Card>();
		size = 0;
	}
	
	public void addCard(Card newCard){
		hand.add(newCard);
	}
	
	public int size(){
		return size;
	}
	
	public void resetHand(){
		size = 0;
		hand.removeAll(hand);
	}
}
