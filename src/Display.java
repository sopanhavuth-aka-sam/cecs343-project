import javax.swing.*;
import java.awt.*;

public class Display extends JFrame {
	
	private ControlPane testPane = new ControlPane();
	private ImagePane testImage = new ImagePane();
	
	public Display(){  
		setSize(1000,750);  
		setLayout(new FlowLayout());  //change later
		
		//adding ImagePane
		
		//testing drawPlayer////////
		drawPlayer("John", 72, 148, 1);
		drawPlayer("Mary", 432, 40, 1);
		drawPlayer("John2", 72, 148, 2);
		////////////////////////////
		
		JScrollPane scrollImage = new JScrollPane(testImage);
		scrollImage.setPreferredSize(new Dimension(1000,500));
		this.getContentPane().add(scrollImage);
		
		//adding controlPane
		this.add(testPane);
		
		this.setVisible(true);
		}

	public void drawToken(String name, int x, int y, int drawPos) {
		
		JLabel player = new JLabel(name);
		player.setFont(player.getFont().deriveFont(Font.BOLD, 30));
		player.setForeground(Color.orange);
		testImage.add(player);
		player.setLocation(x, y + (35 * drawPos));
		player.setSize(100, 30);
	}
}
