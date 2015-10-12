import java.awt.Point;

/**
 * 
 * @author sam
 *
 */
public class Room {
	
	/**
	 * 
	 */
	private int[] connectedRoom;
	private String name;
	private int location; // room location relative to the whole board
	private Point position = new Point(); //where player name should draw.
	
	/**
	 * class constructor
	 *  
	 * @param connectedRoom	array of rooms that are connected to this room
	 * @param name			name of this room; eg: hall, cafeteria
	 * @param location		its location relative to the whole map/board
	 * @param x				its x coordinate on the map/board
	 * @param y				its y coordinate on the map/board
	 */
	public Room(int[] connectedRoom, String name, int location, int x, int y) {
		this.connectedRoom = connectedRoom;
		this.name = name;
		this.location = location;
		this.position.setLocation(x, y);
	}
	
	/**
	 * retrieve what room is connected to this room
	 * 
	 * @return rooms that connected to this room
	 */
	public int[] getConnectedRoom() {
		return this.connectedRoom;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getLoc() {
		return this.location;
	}
	
	/**
	 * 
	 * @return
	 */
	public Point getPos() {
		return this.position;
	}
}