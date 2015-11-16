import java.awt.Point;

/**
 * This class represent the board game. It construct and initialize all the 
 * rooms in the board.
 * 
 * @author sam
 *
 */
public class Board {
	
	/**
	 * room:	array of rooms within the maps
	 * totalQP:	sum of all player Quality Points. Once it reach a certain limits
	 * 			, year of player go up (eg. freshmen to sophomore)
	 */
	private Room[] room = new Room[21]; 
	private int totalQP;
	
	/**
	 * constructor: create and initialize all the rooms
	 */
	public Board() {

		int[] connectToRoom0 = {1, 3, 4, 5};
		int[] connectToRoom1 = {0, 2, 3};
		int[] connectToRoom2 = {1, 3, 5, 6};
		int[] connectToRoom3 = {0, 1, 2, 5};
		int[] connectToRoom4 = {0, 5, 7, 12};
		int[] connectToRoom5 = {0, 2, 3, 4, 6};
		int[] connectToRoom6 = {2, 5, 10};
		int[] connectToRoom7 = {4, 8};
		int[] connectToRoom8 = {7, 9, 16};
		int[] connectToRoom9 = {8, 10};
		int[] connectToRoom10 = {6, 9, 15};
		int[] connectToRoom11 = {12};
		int[] connectToRoom12 = {4, 11, 13, 14, 15, 16};
		int[] connectToRoom13 = {12};
		int[] connectToRoom14 = {12, 15};
		int[] connectToRoom15 = {10, 12, 14, 17, 18, 19, 20};
		int[] connectToRoom16 = {8, 12};
		int[] connectToRoom17 = {15};
		int[] connectToRoom18 = {15};
		int[] connectToRoom19 = {15};
		int[] connectToRoom20 = {15};
		
		room[0] = new Room(connectToRoom0, "George Allen Field", 0, 72, 148);
		room[1] = new Room(connectToRoom1, "Japanese Garden", 1, 432, 40);
		room[2] = new Room(connectToRoom2, "Student Parking", 2, 1023, 78);
		room[3] = new Room(connectToRoom3, "The Pyramid", 3, 420, 274);
		room[4] = new Room(connectToRoom4, "West Walkway", 4, 38, 663);
		room[5] = new Room(connectToRoom5, "Recreation Center", 5, 440, 560);
		room[6] = new Room(connectToRoom6, "Forbidden Parking", 6, 1116, 587);
		room[7] = new Room(connectToRoom7, "library", 7, 20, 1707);
		room[8] = new Room(connectToRoom8, "Union - LA 5", 8, 512, 1707);
		room[9] = new Room(connectToRoom9, "Brotman Hall", 9, 1151, 1707);
		room[10] = new Room(connectToRoom10, "East Walkway", 10, 1462, 989);
		room[11] = new Room(connectToRoom11, "Computer Lab", 11, 170, 885);
		room[12] = new Room(connectToRoom12, "North Hall", 12, 170, 1147);
		room[13] = new Room(connectToRoom13, "Room of Retirement", 13, 170, 1349);
		room[14] = new Room(connectToRoom14, "ECS 302", 14, 602, 885);
		room[15] = new Room(connectToRoom15, "South Hall", 15, 843, 1147);
		room[16] = new Room(connectToRoom16, "Elevators", 16, 605, 1349);
		room[17] = new Room(connectToRoom17, "ECS 308", 17, 811, 1349);
		room[18] = new Room(connectToRoom18, "EAT Club", 18, 1029, 885);
		room[19] = new Room(connectToRoom19, "CECS Conference Room", 19, 1245, 885);
		room[20] = new Room(connectToRoom20, "Lactation Lounge", 20, 1213, 1349);
	}
	
	/**
	 * get list of room that connected to i
	 * 
	 * @param i		number of the room to retrieve list of connected rooms from
	 * @return		int array of connected room from the param
	 */
	public int[] getConnectedRoom(int i) {
		return room[i].getConnectedRoom();
	}
	
	/**
	 * get name of the room i
	 * 
	 * @param i 	number of room to get the name from
	 * @return		name string of the room
	 */
	public String getName(int i) {
		return room[i].getName();
	}
	
	/**
	 * get location number of room i relative the whole map
	 * 
	 * @param i		number of room to get location from
	 * @return		int location of the room
	 */
	public int getLoc(int i) {
		return room[i].getLoc();
	}
	
	/**
	 * get pixel position of where the room i is. This is also where we print
	 * token of players on the board
	 * 
	 * @param i		number of room to get pixel position from
	 * @return		a Point object of where approximately the room is.
	 */
	public Point getPos(int i) {
		return room[i].getPos();
	}
}
