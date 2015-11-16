import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private static final int TOTAL_ROOM = 21;

	/**
	 * 
	 */
	public Controller() {
		gameBoard = new Board();
		gameDisplay = new Display();
		human = new Player("Jimmy", 17, 0, 0, 0 , 0, 1, 1);
		ai1 = new Player("Mary", 17, 6, 6, 6 , 6, 1, 2);
		ai2 = new Player("Tom", 17, 0, 0, 0 , 0, 1, 3);
		//deck = new Deck();
		playerHand = new Hand();

		updateInfoPanel();
		updateConnectedRoomList();
		drawAllTokens();
		moveBtnListener();
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
	
	public void updateHuman(){
		Player player = human;
		gameDisplay.updateHuman(player);
	}
	
	public void updateAI1(){
		Player player = ai1;
		gameDisplay.updateAI1(player);
	
	}
	
	public void updateAI2(){
		Player player = ai2;
		gameDisplay.updateAI2(player);
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

			public void actionPerformed(ActionEvent e) {
				
				//get Human player's new room number.
				int newLoc = roomNameToLoc(gameDisplay.getSelectedRoom());
				//update human player's loc
				human.setLoc(newLoc);
				//update and redraw map
				clearAllTokens();
				drawAllTokens();
				//update connected rooms list(JList)
				updateConnectedRoomList();
			}
			
		});
	}
	
	public void drawCardBtnListener() {
		gameDisplay.drawCardBtnListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				playerHand.addCard(deck.deal());
			}
			
		});
	}
}
