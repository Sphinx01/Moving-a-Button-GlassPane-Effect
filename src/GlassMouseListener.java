import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;

public class GlassMouseListener extends MouseAdapter{
	private GlassPane glass;
	private BufferedImage image;
	
	public GlassMouseListener(GlassPane glass) {
		this.glass = glass;
	}
	
	public void mousePressed(MouseEvent event) {
		//We define the component so we get its location
		Component component = event.getComponent();
		Point location = (Point)event.getPoint().clone();
		
		/*The following methods allow us, in order, to convert a point into
		  screen coordinates. then convert them into window coordinates */
		
		SwingUtilities.convertPointToScreen(location, component);
		SwingUtilities.convertPointFromScreen(location, glass);
		
		//The following instructions allow us to redraw the component
		image = new BufferedImage(component.getWidth(), component.getHeight(),
				BufferedImage.TYPE_INT_ARGB);
		Graphics g = image.getGraphics();
		component.paint(g);
		glass.setLocation(location);
		glass.setImage(image);
		glass.setVisible(true);
	}
	
	public void mouseReleased(MouseEvent event) {
		JComponent lab = (JComponent)event.getSource();
		TransferHandler handle = lab.getTransferHandler();
		
		handle.exportAsDrag(lab, event, TransferHandler.COPY);
		Component component = event.getComponent();
		Point location = (Point)event.getPoint().clone();
		SwingUtilities.convertPointToScreen(location, component);
		SwingUtilities.convertPointFromScreen(location, glass);
		glass.setLocation(location);
		glass.setImage(null);
		glass.setVisible(false);
	}
}
