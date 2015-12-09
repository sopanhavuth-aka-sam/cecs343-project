import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

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
	private Random rand;
	private int moveLimit;
	private static final int TOTAL_ROOM = 21;
	private boolean updateToYear2 = true; //temporary: find a better way to update deck only once
	
	/**
	 * 
	 */
	public Controller() {
		//initialize model once
		Model.init();
		rand = new Random();
		moveLimit = 2;

		gameBoard = Model.gameBoard;
		deck = Model.deck;
		playerHand = Model.playerHand;
		gameDisplay = Model.gameDisplay;
		human = Model.human;
		ai1 = Model.ai1;
		ai2 = Model.ai2;

		//shuffle deck and deal 5 card to player at the start of the game
		deck.shuffle();
		for(int i = 0; i < 5; i++) {
			playerHand.addCard(deck.deal());
		}
		
		//add to test teleport
		//playerHand.addCard(new Card13());//add to test teleport
		//add to test discard card
//		playerHand.addCard(new Card8());
//		playerHand.addCard(new Card10());
//		playerHand.addCard(new Card17());
//		playerHand.addCard(new Card24());
//		playerHand.addCard(new Card25());
//		playerHand.addCard(new Card27());
//		playerHand.addCard(new Card28());
//		playerHand.addCard(new Card32());
//		playerHand.addCard(new Card37());
		
		//add to test draw card
		playerHand.addCard(new Card25());
//		playerHand.addCard(new Card30());
//		playerHand.addCard(new Card31());
//		playerHand.addCard(new Card33());
		//update player hand in infopane
		updatePlayerHand();
		
		//disable move and play button at the start of game
		gameDisplay.toggleMoveBtn();
		gameDisplay.togglePlayBtn();
		
		updateInfoPanel();
		gameDisplay.updateGameInfo();
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
	
	/**
	 * 
	 */
	public void updatePlayerHand() {
		gameDisplay.updatePlayerHand(playerHand);
	}
	
	/**
	 * 
	 */
	public void updateHuman(){
		gameDisplay.updateHuman(human);
	}
	
	/**
	 * 
	 */
	public void updateAI1(){
		gameDisplay.updateAI1(ai1);
	
	}
	
	/**
	 * 
	 */
	public void updateAI2(){
		gameDisplay.updateAI2(ai2);
	}
	
	/**
	 * 
	 */
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
				//update basic game info in infoPane
				gameDisplay.updateGameInfo();
				//update connected rooms list(JList)
				updateConnectedRoomList();
				//check if player can still move this turn
				if(moveLimit > 0) {
					moveLimit--;
				}
				else {
					gameDisplay.disableMoveBtn();
				}
				
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
				gameDisplay.enableMoveBtn();
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
				//reset move limit for player
				moveLimit = 2;
				//get selected card index to be played
				int selectedCard = gameDisplay.getSelectedCard();
				//get selected card's name
				String selectedName = playerHand.getCard(selectedCard).getName();
				//DEBUG
				Card temp = playerHand.getCard(selectedCard);
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
				
				//update current player's hand to InfoPane
				updatePlayerHand();
				//IGNORE for now -- optimization.//////////////////
				//Idea: when the card is played, the card image is removed and 
				//		the next card image is display.
				gameDisplay.resetSelectedCard();
				gameDisplay.clickImageButton();
				//////////////////////////testing ai movement////////////////////
				ai1Action();
				ai2Action();
				//update deck if total QP > 60
				int totalQP = Model.human.getQP() + Model.ai1.getQP() + Model.ai2.getQP();
				if(totalQP >= 60 && updateToYear2) {
					start2ndYear();
					updateToYear2 = false;
					//DEBUG: PRINT OUT
					System.out.println("Move to 2nd Year");
				}
				//update basic game info in infoPane
				gameDisplay.updateGameInfo();
				//update connected rooms list(JList)
				//This is done to update room list after teleportation
				updateConnectedRoomList();
				//update the infopane for player detail
				updateInfoPanel();
				//update and redraw map (important of "teleport" card)
				clearAllTokens();
				drawAllTokens();

				
				//control the flow of the game by toggling button
				gameDisplay.toggleDrawBtn();
				gameDisplay.disableMoveBtn();
				gameDisplay.togglePlayBtn();
				
				
				////////////////////Debug///////////////////////////
				System.out.println(human.toString());
				System.out.println(temp.getName());
				System.out.println(temp.getReqLoc());
			}
			
		});
	}
	
	/**
	 * ai problem:
	 * 	1. for now we used redundant code for 2 ai. This is done because the 
	 * 		code need to change ai1 and ai2, we cant pass these 2 as param
	 *  2. when playing card that require 'hand'. Our ai does not have hand.
	 *  	(discarding card from hand and deal card to hand);
	 *  3. program throwing random NullPointerException when ai play card that 
	 *  	interact with hand or deck.
	 */
	//implement ai1 behavior
	public void ai1Action() {
		/**
		 * randomize number of move between 0-3
		 */
		int movement = rand.nextInt(4);
		
		/**
		 * move in random direction for 'movement'
		 */
		for(int i=0; i<movement; i++) {
			//get current ai's location
			int currentLoc = ai1.getLoc();
			//get size of connectedRoom array
			int size = gameBoard.getConnectedRoom(currentLoc).length;
			//randomize base on size of connectedRoom for a place to go to
			int newLoc = gameBoard.getConnectedRoom(currentLoc)[rand.nextInt(size)];
			//move ai to the new location
			ai1.setLoc(newLoc);
		}
		//search deck for a card to play
		Card aiCard = deck.deal(ai1.getLoc());
		
		/////////////////Debug/////////////////////////
		System.out.println(ai1.getName());
		System.out.println(ai1.getLoc());
		System.out.println(aiCard.getName());
		System.out.println(aiCard.getReqLoc());
		////////////////////////////////////////////////
		
		ai1 = aiCard.play(ai1);
	}
	
	//implement ai2 behavior
	public void ai2Action() {
		/**
		 * randomize number of move between 0-3
		 */
		int movement = rand.nextInt(4);
		
		/**
		 * move in random direction for 'movement'
		 */
		for(int i=0; i<movement; i++) {
			//get current ai's location
			int currentLoc = ai2.getLoc();
			//get size of connectedRoom array
			int size = gameBoard.getConnectedRoom(currentLoc).length;
			//randomize base on size of connectedRoom for a place to go to
			int newLoc = gameBoard.getConnectedRoom(currentLoc)[rand.nextInt(size)];
			//move ai to the new location
			ai2.setLoc(newLoc);
		}
		//search deck for a card to play
		Card aiCard = deck.deal(ai2.getLoc());
		
		/////////////////Debug/////////////////////////
		System.out.println(ai2.getName());
		System.out.println(ai2.getLoc());
		System.out.println(aiCard.getName());
		System.out.println(aiCard.getReqLoc());
		////////////////////////////////////////////////
		
		ai2 = aiCard.play(ai2);
	}
	
	public void start2ndYear() {
		//clear player hand
		Model.playerHand.resetHand();
		//update deck
		Model.deck.clearDeck();
		Model.deck.start2ndYear();
		//draw 5 cards from new deck to player's hand
		Model.deck.shuffle();
		for(int i = 0; i < 5; i++) {
			Model.playerHand.addCard(Model.deck.deal());
		}
		deck = Model.deck;
		playerHand = Model.playerHand;
	}
	
}
