import javax.swing.*;
import java.awt.*;

public class Display extends JFrame {
	
	//private ControlPane testPane = new ControlPane();
	private ImagePane testImage = new ImagePane();
	private InfoPane info = new InfoPane();
	
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
		
		//testing drawPlayer////////
		drawToken("John", 72, 148, 1);
		drawToken("Mary", 432, 40, 1);
		drawToken("John2", 72, 148, 2);
		////////////////////////////
		
		JScrollPane scrollImage = new JScrollPane(testImage);
		scrollImage.setPreferredSize(new Dimension(1000,500));
		this.getContentPane().add(scrollImage);
		
		//adding controlPane
		this.add(info);
		
		this.setVisible(true);
		scrollImage.setPreferredSize(new Dimension((int)(width/1.05),(int)(height/1.5)));
		this.getContentPane().add(scrollImage, BorderLayout.NORTH);
		//adding controlPane
		//this.add(testPane);
		this.add(info, BorderLayout.SOUTH);
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
