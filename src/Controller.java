import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * 
 * @author sam
 *
 */
public class Controller {
	
	/**
	 * 
	 */
	private Board gameBoard;
	private Display gameDisplay;
	private Player human, ai1, ai2;
	private Deck deck;
	private Hand playerHand;
	//private ArrayList<Card> playerHand = new ArrayList<Card>();
	private static final int TOTAL_ROOM = 21;
	//private Model model;
	
	/**
	 * 
	 */
	public Controller() {
		Model.init();//initialize model once
		gameBoard = Model.gameBoard;
		gameDisplay = Model.gameDisplay;
		human = Model.human;
		ai1 = Model.ai1;
		ai2 = Model.ai2;
		deck = Model.deck;
		playerHand = Model.playerHand;

		//shuffle deck and deal 5 card to player at the start of the game
		//deck.shuffle();//shuffle is broken
		for(int i = 0; i < 5; i++) {
			playerHand.addCard(deck.deal());
		}
		playerHand.addCard(new Card13());//add to test teleport
		playerHand.addCard(new Card8());//add to test discard card
		updatePlayerHand(); //update player hand in infopane
		
		//disable move and play button at the start of game
		gameDisplay.toggleMoveBtn();
		gameDisplay.togglePlayBtn();
		
		//
		updateInfoPanel();
		updateConnectedRoomList();
		drawAllTokens();
		moveBtnListener();
		drawCardBtnListener();
		playCardBtnListener();
	}
	
	/**
	 * 
	 */
	public void drawAllTokens() {
		gameDisplay.drawToken(human.getName(), gameBoard.getPos(human.getLoc()), human.getDrawPos());
		gameDisplay.drawToken(ai1.getName(), gameBoard.getPos(ai1.getLoc()), ai1.getDrawPos());
		gameDisplay.drawToken(ai2.getName(), gameBoard.getPos(ai2.getLoc()), ai2.getDrawPos());
	}

	/**
	 * 
	 */
	public void clearAllTokens() {
		gameDisplay.clearAllTokens();
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public int roomNameToLoc(String name) {
		for(int i=0; i<TOTAL_ROOM; i++) {
			if(name.equals(gameBoard.getName(i))) {
				return i;
			}
		}
		System.out.println("Error in RoomName to Loc in Controller Class");
		return -1;
	}
	
	/**
	 * 
	 */
	public void updateConnectedRoomList() {
		int[] newRoomList = gameBoard.getConnectedRoom(human.getLoc());
		String[] newRoomsStr = new String[newRoomList.length];
		for(int i=0; i<newRoomList.length; i++) {
			newRoomsStr[i] = gameBoard.getName(newRoomList[i]);
		}
		gameDisplay.updateRoomList(newRoomsStr);
	}
	
	public void updatePlayerHand() {
		gameDisplay.updatePlayerHand(playerHand);
	}
	
	public void updateHuman(){
		gameDisplay.updateHuman(human);
	}
	
	public void updateAI1(){
		gameDisplay.updateAI1(ai1);
	
	}
	
	public void updateAI2(){
		gameDisplay.updateAI2(ai2);
	}
	
	public void updateInfoPanel(){
		updateHuman();
		updateAI1();
		updateAI2();
	}
	
	/**
	 * 
	 */
	public void moveBtnListener() {
		gameDisplay.moveBtnListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//get Human player's new room number.
				int newLoc = roomNameToLoc(gameDisplay.getSelectedRoom());
				//update human player's location
				human.setLoc(newLoc);
				//update and redraw map
				clearAllTokens();
				drawAllTokens();
				//update connected rooms list(JList)
				updateConnectedRoomList();
				gameDisplay.updateGameInfo();
				
			}
			
		});
	}
	
	public void drawCardBtnListener() {
		gameDisplay.drawCardBtnListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//add card from deck to hand
				playerHand.addCard(deck.deal());
				//update player hand in infoPane
				updatePlayerHand();
				//enable move and play button
				gameDisplay.toggleMoveBtn();
				gameDisplay.togglePlayBtn();
				//disable draw button
				gameDisplay.toggleDrawBtn();
				//update basic game info in infoPane
				gameDisplay.updateGameInfo();
				
				///test code//////
				System.out.println("card is draw");
				System.out.println(playerHand.size());
				
			}
			
		});
	}
	
	public void playCardBtnListener() {
		gameDisplay.playCardBtnListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println(human.toString());
				//get selected card index to be played
				int selectedCard = gameDisplay.getSelectedCard();
				//get selected card's name
				String selectedName = playerHand.getCard(selectedCard).getName();
				//play the selected card
				human = playerHand.getCard(selectedCard).play(human);
				/**
				 * remove selected card from hand (using selectedName)
				 * this is done because index of selected card change when playing
				 * a card that allow discarding or drawing card
				 */
				for (int i = 0; i < playerHand.size(); i++) {
					if(playerHand.getCard(i).getName().equals(selectedName)) {
						playerHand.removeCard(i);
					}
				}
				
//				//remove selected card from hand
//				playerHand.removeCard(selectedCard);
				//update current player's hand to InfoPane
				updatePlayerHand();
				//IGNORE for now -- optimization.//////////////////
				//Idea: when the card is played, the card image is removed and 
				//		the next card image is display.
				gameDisplay.resetSelectedCard();
				gameDisplay.clickImageButton();
				//update and redraw map (important of "teleport" card)
				clearAllTokens();
				drawAllTokens();
				//update the infopane for player detail
				updateInfoPanel();
				gameDisplay.toggleDrawBtn();
				gameDisplay.toggleMoveBtn();
				gameDisplay.togglePlayBtn();
				
				////////////////////Debug///////////////////////////
				System.out.println(human.toString());
			}
			
		});
	}
	
	//implement ai behavior
	public void aiAction() {
		
	}
}
