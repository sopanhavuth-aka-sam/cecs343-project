import java.awt.*;
import javax.swing.*;


public class ImagePane extends JPanel {

	private JLabel mapLabel;

	public ImagePane() {
		
		mapLabel = new JLabel(new ImageIcon("CSULBMap3.png"));
		mapLabel.setPreferredSize(new Dimension(1670,2000));
		this.add(mapLabel);
	}
	
	public void drawPlayer1() {
		
	}
	
	public void drawAI1() {
		
	}
	
	public void drawAI2() {
		
	}
}
