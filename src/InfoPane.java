import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class InfoPane extends JPanel {

	private JButton drawCardBtn, moveBtn, playCardBtn;
	private JList connectedRoomList;
	private String[] roomName;
	private JPanel panel;
	private JTextArea areaEN;
	private JTextArea areaES;
	private JTextArea areaCS;
	private JLabel labelENCWN;
	private JLabel labelENCWC;
	
	public InfoPane(){
		view();
		
		
	}
		
	public void view(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int) screenSize.getHeight();
		height = height - (int)(height/1.42);
		int width = (int) screenSize.getWidth();
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(width, height));
		
		// East
		JPanel panelEast = new JPanel();
		this.add(panelEast, BorderLayout.EAST);
		
		
		// Center
		JPanel panelCenter = new JPanel();
		this.add(panelCenter, BorderLayout.CENTER);
		
		//West
		JPanel panelWest = new JPanel();
		this.add(panelWest, BorderLayout.WEST);
		panelWest.setLayout(new BoxLayout(panelWest, BoxLayout.Y_AXIS));
		drawCardBtn = new JButton("Draw Card");
		panelWest.add(drawCardBtn, BorderLayout.WEST);
		
		moveBtn = new JButton("    Move    ");
		panelWest.add(moveBtn, BorderLayout.WEST);
		
		playCardBtn = new JButton("Play Card");
		panelWest.add(playCardBtn, BorderLayout.WEST);
		
		/*
		// East-North
		JPanel panelEN = new JPanel();
		panelEast.add(panelEN, BorderLayout.NORTH);
		JTable table;
		String[] column = {"", "Learning", "Craft", "Integrity", "Quality Points"};
		Object[][] data = {{"Matt", "6", "6", "6", "0"},{"Amanda", "6", "6", "6", "0"},
						   {"Habib", "6", "6", "6", "0"}};
		table = new JTable(data, column);
		labelENCWN = new JLabel("Cards in Deck: " + "3" + "/t/tDiscards out of play: " + "0");
		labelENCWC = new JLabel("You are " + "Amanda" + "and you are in " + "ECS 308");
		
		areaEN = new JTextArea();
		areaEN.setEditable(false);
		areaEN.setLineWrap(true);
		areaEN.setWrapStyleWord(true);
		areaEN.add(table, BorderLayout.NORTH);
		
		
		// East-North-Center
		JPanel panelENC = new JPanel();
		//panelEN.add(panelENC, BorderLayout.CENTER);
		
		// East-North-Center-West
		JPanel panelENCW = new JPanel();
		panelENC.add(panelENCW, BorderLayout.WEST);
		panelENCW.add(labelENCWN,  BorderLayout.NORTH);
		panelENCW.add(labelENCWC, BorderLayout.CENTER);
		areaEN.add(panelENC, BorderLayout.CENTER);
		panelEN.add(areaEN, BorderLayout.CENTER);
		//panelENCW.add(new JLabel("Cards in Deck: " + "3" + "/t/tDiscards out of play: " + "0"), BorderLayout.NORTH);
		//panelENCW.add(new JLabel("You are " + "Amanda" + "and you are in " + "ECS 308"), BorderLayout.CENTER);
		
		// East-South
		JPanel panelES = new JPanel();
		areaES = new JTextArea("Human player" + "is" + "Amanda");
		areaES.setEditable(false);
		areaES.setLineWrap(true);
		areaES.setWrapStyleWord(true);
		JScrollPane scroll = new JScrollPane(areaES);
		panelEast.add(panelES, BorderLayout.SOUTH);
		panelES.add(scroll);
		*/
		// Center-East
		JPanel panelCE = new JPanel();
		//panelCenter.add(panelCE, BorderLayout.EAST);
		panelCE.add(new JLabel(new ImageIcon("")));
		
		// Center-North
		JPanel panelCN = new JPanel();
		panelCenter.add(panelCN, BorderLayout.NORTH);
		
		// Center-North-west
		//JPanel panelCNW = new JPanel();

		//panelCN.add(panelCNW, BorderLayout.WEST);
		//panelCenter.add(panelCN, BorderLayout.NORTH);
		
		
		// Center-South
		JPanel panelCS = new JPanel();
		//panelCenter.add(panelCS, BorderLayout.SOUTH);
		areaCS = new JTextArea();
		areaCS.setEditable(false);
		areaCS.setLineWrap(true);
		areaCS.setWrapStyleWord(true);
		areaCS.setPreferredSize(new Dimension(50, 50));
		panelCS.add(areaCS, BorderLayout.CENTER);
		
		//JPanel panelCC = new JPanel();
		
		
		roomName = new String[]{"test1", "test2"}; //update string[] after very move;
		connectedRoomList = new JList(roomName);
	}
}
