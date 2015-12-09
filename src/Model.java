//using this class to store all data object
public class Model {
	
	public static Board gameBoard;
	public static Display gameDisplay;
	public static Player human, ai1, ai2;
	public static Deck deck = new Deck();;
	public static Hand playerHand = new Hand();;
	
	//constructor
	public Model() {
	}
	
	public static void init() {
		Deck deck = new Deck();
		playerHand = new Hand();
		gameBoard = new Board();
		gameDisplay = new Display();
		human = new Player("Jimmy", 17, 6, 6, 6 , 15, 1, 1, true);
		ai1 = new Player("Mary", 17, 6, 6, 6 , 15, 1, 2, false);
		ai2 = new Player("Tom", 17, 6, 6, 6, 15, 1, 3, false);
	}
	
}
