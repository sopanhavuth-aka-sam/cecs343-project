import java.util.ArrayList;

public class Hand {
	
	private ArrayList<Card> hand;
	private int size;
	
	public Hand(){
		hand = new ArrayList<Card>();
	}
	
	public void addCard(Card newCard){
		hand.add(newCard);
	}
	
	public int size(){
		return hand.size();
	}
	
	public void resetHand(){
		hand.removeAll(hand);
	}
	
	public Card getCard(int index) {
		return hand.get(index);
	}
	
	public void removeCard(int index) {
		hand.remove(index);
	}
}
