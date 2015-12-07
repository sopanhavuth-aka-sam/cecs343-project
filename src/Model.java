//using this class to store all data object
public class Model {
	
	public static Board gameBoard;
	public static Display gameDisplay;
	public static Player human, ai1, ai2;
	public static Deck deck;
	public static Hand playerHand;
	
	//constructor
	public Model() {
	}
	
	public static void init() {
		deck = new Deck();
		gameBoard = new Board();
		gameDisplay = new Display();
		human = new Player("Jimmy", 17, 6, 6, 6 , 0, 1, 1);
		ai1 = new Player("Mary", 17, 6, 6, 6 , 0, 1, 2);
		ai2 = new Player("Tom", 17, 6, 6, 6, 0, 1, 3);
		playerHand = new Hand();
	}
	
}
