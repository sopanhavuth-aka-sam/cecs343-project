import javax.swing.*;


public class ControlPane extends JPanel {
	
	private JButton drawCardBtn, moveBtn, playCardBtn;
	private JList connectedRoomList;
	private String[] roomName;
	
	public ControlPane() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setVisible(true);
		
		drawCardBtn = new JButton("Draw Card");
		moveBtn = new JButton("Move");
		playCardBtn = new JButton("Play Card");
		roomName = new String[]{"test1", "test2"}; //update string[] after very move;
		connectedRoomList = new JList(roomName);
		
		this.add(drawCardBtn);
		this.add(moveBtn);
		this.add(playCardBtn);
		this.add(connectedRoomList);
	}
}
