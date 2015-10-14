import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * 
 * @author sam
 *
 */
public class ImagePane extends JPanel {
	
	/**
	 * 
	 */
	private Image backgroundImage;

	/**
	 * 
	 */
	public ImagePane() {
		
		this.setPreferredSize(new Dimension(1670,2000));
		this.setLayout(null);
		
		try {
			backgroundImage = ImageIO.read(new File("CSULBMap3.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, this);
	}
}
