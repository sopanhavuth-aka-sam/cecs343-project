import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * 
 * @author sam
 *
 */
public class Display extends JFrame {
	
	/**
	 * 
	 */
	private ImagePane imageP = new ImagePane();
	private InfoPane info = new InfoPane();
	
	/**
	 * 
	 */
	public Display(){  
		setSize(1000,750);  
		setLayout(new FlowLayout());  //change later

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int) screenSize.getHeight();
		int width = (int) screenSize.getWidth();
		setSize(width,height); 
		setLayout(new BorderLayout());  
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();

		
		//adding ImagePane
		
		JScrollPane scrollImage = new JScrollPane(imageP);
		this.setVisible(true);
		scrollImage.setPreferredSize(new Dimension((int)(width/1.05),(int)(height/1.5)));
		this.getContentPane().add(scrollImage, BorderLayout.NORTH);
		
		//adding InfoPane
		this.add(info);
	}

	/**
	 * 
	 * @param name
	 * @param pos
	 * @param drawPos
	 */
	public void drawToken(String name, Point pos, int drawPos) {
		
		JLabel player = new JLabel(name);
		player.setFont(player.getFont().deriveFont(Font.BOLD, 30));
		player.setForeground(Color.orange);
		imageP.add(player);
		player.setLocation(pos.x, pos.y + (35 * drawPos));
		player.setSize(300, 30);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getSelectedRoom() {
		return info.getSelectedRoom();
	}
	
	/**
	 * 
	 * @param newList
	 */
	public void updateRoomList(String[] newList) {
		info.updateConnectedRoomList(newList);
	}
	
	public void updateHuman(Player name){
		info.updateHuman(name);
	}
	
	public void updateAI1(Player name){
		info.updateAI1(name);
	}
	
	public void updateAI2(Player name){
		info.updateAI2(name);
	}
	
	/**
	 * 
	 */
	public void clearAllTokens() {
		imageP.removeAll();
		imageP.revalidate();
		imageP.repaint();
	}
	
	/**
	 * 
	 * @param al
	 */
	public void moveBtnListener(ActionListener al) {
		info.moveBtnListener(al);
	}
	
	public void drawCardBtnListener(ActionListener al) {
		info.drawCardBtnListener(al);
	}
}
