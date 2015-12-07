//using this class to store all data object
public class Model {
	
	public static Board gameBoard;
	public static Display gameDisplay;
	public static Player human, ai1, ai2;
	public static Deck deck;
	public static Deck discardDeck;
	public static Hand playerHand;
	
	//constructor
	public Model() {
	}
	
	public static void init() {
		human = new Player("Jimmy", 17, 2, 2, 2 , 0, 1, 1);
		ai1 = new Player("Mary", 17, 3, 1, 2 , 0, 1, 2);
		ai2 = new Player("Tom", 17, 0, 3, 3 , 0, 1, 3);
		deck = new Deck();
		discardDeck = new Deck();
		gameBoard = new Board();
		gameDisplay = new Display();
		playerHand = new Hand();
	}
	
}
