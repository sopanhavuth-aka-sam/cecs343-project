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
	private JTextArea areaWS;
	private JLabel labelENCWN;
	private JLabel labelENCWC;

	public InfoPane() {
		view();

	}

	public void view() {
		Color white = new Color(255, 255, 255);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int) screenSize.getHeight();
		height = height - (int) (height / 1.43);
		int width = (int) screenSize.getWidth();
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(width, height));

		// East
		JPanel panelEast = new JPanel();
		this.add(panelEast, BorderLayout.EAST);
		panelEast.setLayout(new BorderLayout());
		
		// East-North
		JPanel panelEN = new JPanel();
		panelEast.add(panelEN, BorderLayout.NORTH);
		panelEN.setLayout(new BorderLayout());
		panelEN.setBackground(white);
		panelEN.setPreferredSize(new Dimension(800, 150));
		
		JTable table; 
		String[] column = {" ", "Learning", "Craft", "Integrity", "Quality Points"};
		Object[][] data = {{" ", "Learning", "Craft", "Integrity", "Quality Points"},
				           {"Matt", "6", "6", "6", "0"},
						   {"Amanda", "6", "6", "6", "0"}, 
						   {"Habib", "6", "6", "6", "0"}
						   };
		table = new JTable(data, column);
		table.setShowGrid(false);
		table.setIntercellSpacing(new Dimension(0,0));
		table.setPreferredSize(new Dimension(450, 50));
		panelEN.add(table, BorderLayout.WEST);
		
		areaEN = new JTextArea();
		areaEN.setText("Cards in deck: " + "34\t" + "Discards out of play: " + "0\n");
		areaEN.append("You are " + "Amanda" + "and you are in " + "ECS 308");
		panelEN.add(areaEN, BorderLayout.SOUTH);
		
		
		// East-South
		JPanel panelES = new JPanel();
		panelEast.add(panelES, BorderLayout.SOUTH);
		panelES.setLayout(new FlowLayout());
		areaES = new JTextArea();
		areaES.setEditable(false);
		areaES.setLineWrap(true);
		areaES.setWrapStyleWord(true);
		areaES.setPreferredSize(new Dimension(800, 60));
		
		JScrollPane scroll = new JScrollPane(areaES);
		scroll.setPreferredSize(new Dimension(800,60));
		panelES.add(scroll);

		// Center
		JPanel panelCenter = new JPanel();
		this.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new BorderLayout());
		
		JPanel panelCF = new JPanel();
		panelCenter.add(panelCF);
		panelCF.setLayout(new FlowLayout());
		
		JTextArea areaC = new JTextArea();
		areaC = new JTextArea();
		areaC.setEditable(false);
		areaC.setLineWrap(true);
		areaC.setWrapStyleWord(true);
		areaC.setPreferredSize(new Dimension(200, 200));
		panelCF.add(areaC, BorderLayout.WEST);

		// West
		JPanel panelWest = new JPanel();
		this.add(panelWest, BorderLayout.WEST);
		panelWest.setLayout(new BorderLayout());
		
		// West-South
		JPanel panelWS = new JPanel();
		panelWest.add(panelWS, BorderLayout.SOUTH);
		panelWS.setLayout(new FlowLayout());
		areaWS = new JTextArea();
		areaWS.setEditable(false);
		areaWS.setLineWrap(true);
		areaWS.setWrapStyleWord(true);
		areaWS.setPreferredSize(new Dimension(170, 120));
		panelWS.add(areaWS);
		

		// West-North
		JPanel panelWN = new JPanel();
		panelWest.add(panelWN, BorderLayout.WEST);
		panelWN.setLayout(new FlowLayout());
		
		JPanel panelWNG = new JPanel();
		panelWN.add(panelWNG);
		panelWNG.setLayout(new GridLayout(3, 1, 0, 5));

		drawCardBtn = new JButton("Draw Card");
		panelWNG.add(drawCardBtn);

		moveBtn = new JButton("Move");
		panelWNG.add(moveBtn);

		playCardBtn = new JButton("Play Card");
		panelWNG.add(playCardBtn);

		// Center-East
		JPanel panelCE = new JPanel();
		// panelCenter.add(panelCE, BorderLayout.EAST);
		panelCE.add(new JLabel(new ImageIcon("")));

		// Center-North
		JPanel panelCN = new JPanel();
		panelCenter.add(panelCN, BorderLayout.NORTH);

		// Center-North-west
		// JPanel panelCNW = new JPanel();

		// panelCN.add(panelCNW, BorderLayout.WEST);
		// panelCenter.add(panelCN, BorderLayout.NORTH);

		// JPanel panelCC = new JPanel();

		roomName = new String[] { "test1", "test2" }; // update string[] after
														// very move;
		connectedRoomList = new JList(roomName);
	}
}
