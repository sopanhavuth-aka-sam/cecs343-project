import java.util.Arrays;


public class main {
	
public static void main(String[] args) {  
	
	Board testBoard = new Board();
	System.out.println(testBoard.getName(0));
	System.out.println(Arrays.toString(testBoard.getConnectedRoom(0)));
	System.out.println(testBoard.getLoc(0));
	System.out.println(testBoard.getPos(0));
	
	Display testDisplay = new Display();
	
}  
}  