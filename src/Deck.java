import java.util.ArrayList;
import java.util.Random;

public class Deck{
	
	private ArrayList<Card> deck = new ArrayList<Card>();
	private Random rand;
	
	public Deck(){
		deck.add(new Card1());
		deck.add(new Card2());
		deck.add(new Card3());
		deck.add(new Card4());
		deck.add(new Card5());
		deck.add(new Card6());
		deck.add(new Card7());
		deck.add(new Card8());
		deck.add(new Card9());
		deck.add(new Card10());
		deck.add(new Card11());
		deck.add(new Card12());
		deck.add(new Card13());
		deck.add(new Card14());
		deck.add(new Card15());
		deck.add(new Card16());
		deck.add(new Card17());
		deck.add(new Card18());
		deck.add(new Card19());
		deck.add(new Card20());
		deck.add(new Card21());
		deck.add(new Card22());
		deck.add(new Card23());
		deck.add(new Card24());
		deck.add(new Card25());
		deck.add(new Card26());
		deck.add(new Card27());
		deck.add(new Card28());
		deck.add(new Card29());
		deck.add(new Card30());
		deck.add(new Card31());
		deck.add(new Card32());
		deck.add(new Card33());
		deck.add(new Card34());
		//deck.add(new Card35());
		deck.add(new Card36());
		//deck.add(new Card37());
		deck.add(new Card38());
		//deck.add(new Card39());
		
		shuffle(deck);
		
	}
	
	public ArrayList getDeck(){
		return deck;
	}
	
	public void shuffle(ArrayList discardDeck){
		rand = new Random();
		for(int i = discardDeck.size(); i >= 0; i--){
			int index = rand.nextInt(i + 1);
			Object temp = discardDeck.get(i);
			discardDeck.set(i, discardDeck.get(index));
			discardDeck.set(index, temp);
		}
		
		for(int index = 0; index < discardDeck.size(); index++){
			//deck.add(discardDeck.remove(index));
		}
	}
	
	public Card deal(){
		if(deck.size() > 0) {
			Card temp = deck.get(0);
			deck.remove(0);
			return temp;
		}
		else {
			System.out.println("The deck is empty");
			return null;
		}
	}
}
