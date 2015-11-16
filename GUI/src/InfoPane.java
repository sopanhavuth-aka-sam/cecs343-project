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
	private Player human, ai1, ai2;
	private DefaultListModel roomNames;
	private DefaultTableModel model;
	

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
		human = new Player("", 0, 0, 0, 0, 0, 0, 0);
		ai1 = new Player("", 0, 0, 0, 0, 0, 0, 0);
		ai2 = new Player("", 0, 0, 0, 0, 0, 0, 0);
		
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
		Object[] column = {" ", "Learning", "Craft", "Integrity", "Quality Points"};
		Object[][] data = {{" ", "Learning", "Craft", "Integrity", "Quality Points"},
				           {human.getName(), Integer.toString(human.getLearningPts()), Integer.toString(human.getCraftPts()), Integer.toString(human.getIntegrityPts()), Integer.toString(human.getQP())},
						   {ai1.getName(), Integer.toString(ai1.getLearningPts()), Integer.toString(ai1.getCraftPts()), Integer.toString(ai1.getIntegrityPts()), Integer.toString(ai1.getQP())},
						   {ai2.getName(), Integer.toString(ai2.getLearningPts()), Integer.toString(ai2.getCraftPts()), Integer.toString(ai2.getIntegrityPts()), Integer.toString(ai2.getQP())}
						   };
		model = new DefaultTableModel(data, column);
		table = new JTable(model);
		table.setShowGrid(false);
		table.setIntercellSpacing(new Dimension(0,0));
		table.setPreferredSize(new Dimension(450, 50));
		table.setEnabled(false);
		panelEN.add(table, BorderLayout.WEST);

		areaEN = new JTextArea();
		areaEN.setText("Cards in deck: " + "34\t" + "Discards out of play: " + "0\n");
		//areaEN.append("You are " + human.getName() + " and you are in " + gameBoard.getName(human.getLoc()));
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
		//areaES.setText("Human player is " + human.getName());
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
	
	public void updateHuman(Player name){
		human = name;
		model.setValueAt(human.getName(), 1, 0);
		model.setValueAt(human.getLearningPts(), 1, 1);
		model.setValueAt(human.getCraftPts(), 1, 2);
		model.setValueAt(human.getIntegrityPts(), 1, 3);
		model.setValueAt(human.getQP(), 1, 4);
	}
	
	public void updateAI1(Player name){
		ai1 = name;
		model.setValueAt(ai1.getName(), 2, 0);
		model.setValueAt(ai1.getLearningPts(), 2, 1);
		model.setValueAt(ai1.getCraftPts(), 2, 2);
		model.setValueAt(ai1.getIntegrityPts(), 2, 3);
		model.setValueAt(ai1.getQP(), 2, 4);
	}	
	
	public void updateAI2(Player name){
		ai2 = name;
		model.setValueAt(ai2.getName(), 3, 0);
		model.setValueAt(ai2.getLearningPts(), 3, 1);
		model.setValueAt(ai2.getCraftPts(), 3, 2);
		model.setValueAt(ai2.getIntegrityPts(), 3, 3);
		model.setValueAt(ai2.getQP(), 3, 4);
	}
	
	/**
	 *
	 * @param al
	 */
	public void addListener(ActionListener al) {
		moveBtn.addActionListener(al);
	}
}
