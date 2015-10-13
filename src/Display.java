import javax.swing.*;
import java.awt.*;

public class Display extends JFrame {
	
	//private ControlPane testPane = new ControlPane();
	private ImagePane testImage = new ImagePane();
	private InfoPane info = new InfoPane();
	
	public Display(){  
<<<<<<< HEAD
		setSize(1000,750);  
		setLayout(new FlowLayout());  //change later
=======
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int) screenSize.getHeight();
		int width = (int) screenSize.getWidth();
		setSize(width,height); 
		setLayout(new BorderLayout());  
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
>>>>>>> 97558ac1aa6d637f4c4da0d6d4e3590a62940504
		
		//adding ImagePane
		
		//testing drawPlayer////////
		drawPlayer("John", 72, 148, 1);
		drawPlayer("Mary", 432, 40, 1);
		drawPlayer("John2", 72, 148, 2);
		////////////////////////////
		
		JScrollPane scrollImage = new JScrollPane(testImage);
<<<<<<< HEAD
		scrollImage.setPreferredSize(new Dimension(1000,500));
		this.getContentPane().add(scrollImage);
		
		//adding controlPane
		this.add(testPane);
		
		this.setVisible(true);
=======
		scrollImage.setPreferredSize(new Dimension((int)(width/1.05),(int)(height/1.5)));
		this.getContentPane().add(scrollImage, BorderLayout.NORTH);
		//adding controlPane
		//this.add(testPane);
		this.add(info, BorderLayout.SOUTH);
>>>>>>> 97558ac1aa6d637f4c4da0d6d4e3590a62940504
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
