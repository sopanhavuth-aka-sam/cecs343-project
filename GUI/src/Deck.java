import java.util.ArrayList;
import java.util.Random;

public class Deck {
	
	private ArrayList deck;
	private Random rand;
	private Card1 card1;
	/*private Card3 card3;
	private Card5 card5;
	private Card7 card7;
	private Card9 card9;
	private Card11 card11;
	private Card13 card13;
	private Card15 card15;
	private Card17 card17;
	private Card19 card19;
	private Card21 card21;
	private Card23 card23;
	private Card25 card25;
	private Card27 card27;
	private Card29 card29;
	private Card31 card31;
	private Card33 card33;
	private Card35 card35;
	private Card37 card37;*/
	private Card2 card2;
	private Card4 card4;
	private Card6 card6;
	private Card8 card8;
	private Card10 card10;
	private Card12 card12;
	private Card14 card14;
	private Card16 card16;
	private Card18 card18;
	private Card20 card20;
	private Card22 card22;
	private Card24 card24;
	private Card26 card26;
	private Card28 card28;
	private Card30 card30;
	private Card32 card32;
	private Card34 card34;
	private Card36 card36;
	private Card38 card38;
	
	public Deck(){
		deck.add(card1 = new Card1());
		/*deck.add(card3 = new Card1());
		deck.add(card5 = new Card1());
		deck.add(card7 = new Card1());
		deck.add(card9 = new Card1());
		deck.add(card11 = new Card1());
		deck.add(card13 = new Card1());
		deck.add(card15 = new Card1());
		deck.add(card17 = new Card1());
		deck.add(card19 = new Card1());
		deck.add(card21 = new Card1());
		deck.add(card23 = new Card1());
		deck.add(card25 = new Card1());
		deck.add(card27 = new Card1());
		deck.add(card29 = new Card1());
		deck.add(card31 = new Card1());
		deck.add(card33 = new Card1());
		deck.add(card35 = new Card1());
		deck.add(card37 = new Card1());*/
		deck.add(card2 = new Card2());
		deck.add(card4 = new Card4());
		deck.add(card6 = new Card6());
		deck.add(card8 = new Card8());
		deck.add(card10 = new Card10());
		deck.add(card12 = new Card12());
		deck.add(card14 = new Card14());
		deck.add(card16 = new Card16());
		deck.add(card18 = new Card18());
		deck.add(card20 = new Card20());
		deck.add(card22 = new Card22());
		deck.add(card24 = new Card24());
		deck.add(card26 = new Card26());
		deck.add(card28 = new Card28());
		deck.add(card30 = new Card30());
		deck.add(card32 = new Card32());
		deck.add(card34 = new Card34());
		deck.add(card36 = new Card36());
		deck.add(card38 = new Card38());
		
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
			deck.add(discardDeck.remove(index));
		}
	}
	
	public Object deal(){
		return deck.remove(deck.size() - 1);
	}
}
