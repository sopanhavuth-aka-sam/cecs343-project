import javax.swing.*;
import java.awt.*;

public class Display extends JFrame {
	
	private ControlPane testPane = new ControlPane();
	private ImagePane testImage = new ImagePane();
	
	public Display(){  
		setSize(1000,750);  
		setLayout(new FlowLayout());  
		setVisible(true);
		
		//adding ImagePane
		JScrollPane scrollImage = new JScrollPane(testImage);
		scrollImage.setPreferredSize(new Dimension(1000,500));
		this.getContentPane().add(scrollImage);
		//adding controlPane
		this.add(testPane);
		}
}
