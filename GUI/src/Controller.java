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
	private Display gameDisplay;
	private InfoPane infoPanel;
	private static final int totalRoom = 21; 

	/**
	 * 
	 */
	public Controller() {
		gameDisplay = new Display();
		infoPanel = new InfoPane();
	
		updateConnectedRoomList();
		drawAllTokens();
		addListener();
	}
	
	/**
	 * 
	 */
	public void drawAllTokens() {
		gameDisplay.drawToken(infoPanel.human.getName(), infoPanel.gameBoard.getPos(infoPanel.human.getLoc()), infoPanel.human.getDrawPos());
		gameDisplay.drawToken(infoPanel.ai1.getName(), infoPanel.gameBoard.getPos(infoPanel.ai1.getLoc()), infoPanel.ai1.getDrawPos());
		gameDisplay.drawToken(infoPanel.ai2.getName(), infoPanel.gameBoard.getPos(infoPanel.ai2.getLoc()), infoPanel.ai2.getDrawPos());
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
		for(int i=0; i<totalRoom; i++) {
			if(name.equals(infoPanel.gameBoard.getName(i))) {
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
		int[] newRoomList = infoPanel.gameBoard.getConnectedRoom(infoPanel.human.getLoc());
		String[] newRoomsStr = new String[newRoomList.length];
		for(int i=0; i<newRoomList.length; i++) {
			newRoomsStr[i] = infoPanel.gameBoard.getName(newRoomList[i]);
		}
		gameDisplay.updateRoomList(newRoomsStr);
	}
	
	/**
	 * 
	 */
	public void addListener() {
		gameDisplay.addListener( new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				//get Human player's new room number.
				int newLoc = roomNameToLoc(gameDisplay.getSelectedRoom());
				//update human player's loc
				infoPanel.human.setLoc(newLoc);
				//update and redraw map
				clearAllTokens();
				drawAllTokens();
				//update connected rooms list(JList)
				updateConnectedRoomList();
			}
			
		});
	}
}
