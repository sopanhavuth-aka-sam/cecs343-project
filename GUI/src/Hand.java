import java.util.ArrayList;

public class Hand {
	
	ArrayList myHand;
	private int handSize;
	
	public Hand(){
		handSize = 0;
	}
	
	public void addCard(Object newCard){
		myHand.add(newCard);
		handSize++;
	}
	
	public int handSize(){
		return handSize;
	}
	
	public int resetHand(){
		handSize = 0;
		return handSize;
	}
	
}
