import javax.swing.*;
import java.awt.*;

public class Display extends JFrame {
	
	//private ControlPane testPane = new ControlPane();
	private ImagePane testImage = new ImagePane();
	private InfoPane info = new InfoPane();
	
	public Display(){  
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int) screenSize.getHeight();
		int width = (int) screenSize.getWidth();
		setSize(width,height); 
		setLayout(new BorderLayout());  
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		
		//adding ImagePane
		JScrollPane scrollImage = new JScrollPane(testImage);
		scrollImage.setPreferredSize(new Dimension((int)(width/1.05),(int)(height/1.5)));
		this.getContentPane().add(scrollImage, BorderLayout.NORTH);
		//adding controlPane
		//this.add(testPane);
		this.add(info, BorderLayout.SOUTH);
		}
}
