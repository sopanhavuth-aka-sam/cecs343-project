import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author sam
 *
 */
public class InfoPane extends JPanel {

	/**
	 *
	 */
	public Player human, ai1, ai2;
	public Board gameBoard;
	
	private JButton drawCardBtn, moveBtn, playCardBtn;
	private JList connectedRoomList;
	private JPanel panel;
	private JTextArea areaEN;
	private JTextArea areaES;
	private JTextArea areaWS;
	private String selectedRoom;
	private DefaultListModel roomNames;
	
	private static final int startLoc = 17;

	/**
	 *
	 */
	public InfoPane(){
		gameBoard = new Board();
		human = new Player("Jimmy", startLoc, 6, 6, 6 , 0, 1, 1);
		ai1 = new Player("Mary", startLoc, 6, 6, 6 , 0, 1, 2);
		ai2 = new Player("Tom", startLoc, 6, 6, 6 , 0, 1, 3);
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
		panelEast.setPreferredSize(new Dimension(800, 150));

		// East-North
		JPanel panelEN = new JPanel();
		panelEast.add(panelEN, BorderLayout.NORTH);
		panelEN.setLayout(new BorderLayout());
		panelEN.setBackground(white);
		panelEN.setPreferredSize(new Dimension(800, 150));
		
		JTable table;
		String[] column = {" ", "Learning", "Craft", "Integrity", "Quality Points"};
		Object[][] data = {{" ", "Learning", "Craft", "Integrity", "Quality Points"},
				           {human.getName(), human.getLearningPts(), human.getCraftPts(), human.getIntegrityPts(), human.getQP()},
						   {ai1.getName(), ai1.getLearningPts(), ai1.getCraftPts(), ai1.getIntegrityPts(), ai1.getQP()},
						   {ai2.getName(), ai2.getLearningPts(), ai2.getCraftPts(), ai2.getIntegrityPts(), ai2.getQP()}
						   };
		table = new JTable(data, column);
		table.setShowGrid(false);
		table.setIntercellSpacing(new Dimension(0,0));
		table.setPreferredSize(new Dimension(450, 50));
		table.setEnabled(false);
		panelEN.add(table, BorderLayout.WEST);

		areaEN = new JTextArea();
		areaEN.setText("Cards in deck: " + "34\t" + "Discards out of play: " + "0\n");
		areaEN.append("You are " + human.getName() + " and you are in " + gameBoard.getName(human.getLoc()));
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
		areaES.setText("Human player is " + human.getName());
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
		
		JButton buttonC = new JButton();
		areaC.add(buttonC);
		
		panelCF.add(areaC, BorderLayout.WEST);

		// West
		JPanel panelWest = new JPanel();
		this.add(panelWest, BorderLayout.WEST);
		panelWest.setLayout(new BorderLayout());

		// West-South
		JPanel panelWS = new JPanel();
		panelWest.add(panelWS, BorderLayout.SOUTH);
		panelWS.setLayout(new FlowLayout());
	
		JScrollPane scrollWS = new JScrollPane(connectedRoomList);
		scrollWS.setPreferredSize(new Dimension(170, 130));
		panelWS.add(scrollWS);

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
