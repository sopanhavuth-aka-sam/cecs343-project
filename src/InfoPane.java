import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sam
 *
 */
public class InfoPane extends JPanel {

	/**
	 *
	 */
	
	private JButton drawCardBtn, moveBtn, playCardBtn;
	private JList connectedRoomList;
	private JPanel panel;
	private JTextArea areaEN;
	private JTextArea areaES;
	private JTextArea areaWS;
	private String selectedRoom;
	private DefaultListModel roomNames;
	

	/**
	 *
	 */
	public InfoPane(){
		roomNames = new DefaultListModel();
		connectedRoomList = new JList(roomNames);
		//listSelectionListener
		connectedRoomList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting()){
					selectedRoom = String.valueOf(connectedRoomList.getSelectedValue());
					//Debug: print selected row
					System.out.println(selectedRoom);
				}
			}
		});
		view();
	}

	/**
	 *
	 */
	public void view(){
		//Color white = new Color(255, 255, 255);
		//Get current interface's screen size
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//set current height and width of the screen.
		int height = (int) screenSize.getHeight();
		height = height - (int) (height / 1.43);
		int width = (int) screenSize.getWidth();
		//set preference for InfoPane
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(width, height));

		//East
		//testing code for EAST - game information (ignore game action for now)
		JPanel panelEast = new JPanel();
		this.add(panelEast, BorderLayout.EAST);
		panelEast.setLayout(new BoxLayout(panelEast, BoxLayout.Y_AXIS));
		//set up row and column
		Object[][] row = {
				{"Name", "Learning", "Craft", "Integrity", "Quality Points"},
				{"Jame", "0", "2", "1", "1"},
				{"Joe", "3", "5", "7", "9"},
				{"Mary", "1", "2", "3", "4"}
		   };
		Object[] col = {"name", "learning", "craft", "integrity", "quality points"};
		//insert row and column into DefaultTableModel
		DefaultTableModel modelTable = new DefaultTableModel(row, col);
		//add DefaultTableModel to Table
		JTable table = new JTable(modelTable);
		//add Table to Panel
		panelEast.add(table);
		//test updating value
		modelTable.setValueAt("100", 3, 3); //use this to update all player's info when playButton is clicked.

		//CENTER
		JPanel panelCenter = new JPanel();
		this.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new CardLayout());
		

		// West
		JPanel panelWest = new JPanel();
		this.add(panelWest, BorderLayout.WEST);
		panelWest.setLayout(new BoxLayout(panelWest, BoxLayout.Y_AXIS));
	
		JScrollPane scrollWS = new JScrollPane(connectedRoomList); // Jlist of rooms
		scrollWS.setPreferredSize(new Dimension(170, 130));
		panelWest.add(scrollWS);

		drawCardBtn = new JButton("Draw Card");
		panelWest.add(drawCardBtn);

		moveBtn = new JButton("Move");
		panelWest.add(moveBtn);

		playCardBtn = new JButton("Play Card");
		panelWest.add(playCardBtn);	
		
	}

	/**
	 *
	 * @return
	 */
	public String getSelectedRoom() {
		return selectedRoom;
	}

	/**
	 *
	 * @param newList
	 */
	public void updateConnectedRoomList(String[] newList) {
		roomNames.clear();
		for(int i=0; i<newList.length; i++) {
			roomNames.addElement(newList[i]);
		}
	}
	
	/**
	 *
	 * @param al
	 */
	public void addListener(ActionListener al) {
		moveBtn.addActionListener(al);
	}
}
