import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class GlassPane extends JPanel{
	
	private BufferedImage image; //The image we want to draw
	private Point location; //The coordinates of the image
	private Composite transparency; //Transparency of the glass

	public GlassPane(){
		setOpaque(false); //To be able to draw what we want
		transparency = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.55f); //Let's define the transparency
	}

	public void setLocation(Point location) {
		this.location = location;
	}
	
	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public void paintComponent(Graphics g) {
		if(image == null) //If there's no image to draw, we do nothing.
			return;
		//Otherwise, we draw the image
		Graphics2D g2d = (Graphics2D)g;
		g2d.setComposite(transparency);
		g2d.drawImage(image, (int)(location.getX()-(image.getWidth()/2)),
				(int)(location.getY()-(image.getHeight()/2)), null);
	}
}
