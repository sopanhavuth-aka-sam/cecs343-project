

/**
 * 
 * @author sam
 *
 */
public class Board {
	
	public Room[] room = new Room[21]; //change back to private after testing
	private int totalQP;
	
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
		
		room[0] = new Room(connectToRoom0, "George Allen Field", 0, 0, 0);
		room[1] = new Room(connectToRoom1, "Japanese Garden", 1, 0, 0);
		room[2] = new Room(connectToRoom2, "Student Parking", 2, 0, 0);
		room[3] = new Room(connectToRoom3, "The Pyramid", 3, 0, 0);
		room[4] = new Room(connectToRoom4, "West Walkway", 4, 0, 0);
		room[5] = new Room(connectToRoom5, "Recreation Center", 5, 0, 0);
		room[6] = new Room(connectToRoom6, "Forbidden Parking", 6, 0, 0);
		room[7] = new Room(connectToRoom7, "library", 7, 0, 0);
		room[8] = new Room(connectToRoom8, "Union - LA 5", 8, 0, 0);
		room[9] = new Room(connectToRoom9, "Brotman Hall", 9, 0, 0);
		room[10] = new Room(connectToRoom10, "East Walkway", 10, 0, 0);
		room[11] = new Room(connectToRoom11, "Computer Lab", 11, 0, 0);
		room[12] = new Room(connectToRoom12, "North Hall", 12, 0, 0);
		room[13] = new Room(connectToRoom13, "Room of Retirement", 13, 0, 0);
		room[14] = new Room(connectToRoom14, "ECS 302", 14, 0, 0);
		room[15] = new Room(connectToRoom15, "South Hall", 15, 0, 0);
		room[16] = new Room(connectToRoom16, "Elevators", 16, 0, 0);
		room[17] = new Room(connectToRoom17, "ECS 308", 17, 0, 0);
		room[18] = new Room(connectToRoom18, "EAT Club", 18, 0, 0);
		room[19] = new Room(connectToRoom19, "CECS Conference Room", 19, 0, 0);
		room[20] = new Room(connectToRoom20, "Lactation Lounge", 20, 0, 0);
		
	}
	
	
}
