import java.util.ArrayList;

public class Deck{
	/**
	 * NOTE: The logic of using index a marker between in-play and discarded card
	 * 			is flaw for this program.
	 * 		When the deck ran out of card, We was thinking of reseting the index then shuffle.
	 * 		This result in duplicate cards (a. card in deck and b.card still in hand)
	 * 		This violate the program requirement where it required reshuffling only the discard cards
	 * SOLUTION: require fixing --> set this as part of assignment during winter break.
	 */
	private ArrayList<Card> deck;
	private ArrayList<Card> discardDeck;
	private int index;
	
	public Deck(){
		deck = new ArrayList<Card>();
		discardDeck = new ArrayList<Card>();
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
		deck.add(new Card35());
		deck.add(new Card36());
		deck.add(new Card37());
		deck.add(new Card38());
		deck.add(new Card39());
	}
	
	public void reusedDiscardDeck(){
		for(int i = 0; i < discardDeck.size(); i++){
			deck.add(discardDeck.remove(index));
		}
	}
	
	public void shuffle(){
		for(int i=0; i<deck.size(); i++) {
			int r = i + (int) (Math.random() * (deck.size() - i));
			Card temp = deck.get(r);
			deck.set(r, deck.get(i));
			deck.set(i, temp);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public Card deal(){
		if(index < deck.size()) {
			Card temp = deck.get(index);
			index++;
			return temp;
		}
		else {
			System.out.println("The deck is empty");
			return null;
		}
	}
	
	/**
	 * search the whole deck for a card that fit the required location
	 * @param location
	 * @return
	 */
	public Card deal(int reqLoc) {
		if(index < deck.size()) {
			int counter = index; //used counter to move through deck
								//index is reserved as marker between in-play and discard card
			//searching the deck
			while(counter < deck.size()) {
				//create temp card to return
				Card temp = deck.get(counter);
				//store the required location of current card
				ArrayList<Integer> locArr = temp.getReqLoc();
				//loop to check if the card has the same required room
				for(int i=0; i<locArr.size(); i++) {
					if(locArr.get(i) == reqLoc) {
						//swap and discard this temp card
						swap(index, counter);
						index++;
						//return temp card to caller
						return temp;
					}
				}
				//move counter to the next card
				counter++;
			}
			//if no card left in the deck meet the requirement just deal a card normally
			return this.deal();
		}
		else {
			System.out.println("The deck is empty");
			return null;
		}
	}
	
	public int size(){
		return deck.size() - index;
	}
	
	public int discardDeckSize(){
		return discardDeck.size();
	}
	
	/**
	 * swap index of 2 cards in the deck
	 * @param card1
	 * @param card2
	 */
	public void swap(int card1, int card2) {
		//save card 1 data
		Card temp = deck.get(card1);
		//replace card 1 data with card 2
		deck.set(card1, deck.get(card2));
		//replace card 2 data with temp card
		deck.set(card2, temp);
	}
	
	public int getIndex() {
		return index;
	}
	
}
