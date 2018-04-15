import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

public class GlassMouseMotionListener extends MouseAdapter{
	private GlassPane glass;
	
	public GlassMouseMotionListener(GlassPane glass) {
		this.glass = glass;
	}
	
	public void mouseDragged(MouseEvent event) {
		Component component = event.getComponent();
		Point point = (Point)event.getPoint().clone();
		
		SwingUtilities.convertPointToScreen(point, component);
		SwingUtilities.convertPointFromScreen(point, glass);
		glass.setLocation(point);
		glass.repaint();
	}
}
