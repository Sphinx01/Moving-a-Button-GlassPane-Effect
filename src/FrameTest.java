import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.TransferHandler;

public class FrameTest extends JFrame{
	private GlassPane glass = new GlassPane();
	
	public FrameTest() {
		//Set Title of the frame, size, position and default closing operation
		super("GlassPane Test");
		setSize(400, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel1 = new JPanel(), panel2 = new JPanel();
		JButton button1 = new JButton("Button N1"),
				button2 = new JButton("Button N2");
		JLabel text = new JLabel("A static text"), 
				label = new JLabel("A second static text");
		
		button1.addMouseListener(new GlassMouseListener(glass));;
		button1.addMouseMotionListener(new GlassMouseMotionListener(glass));
		button1.setTransferHandler(new TransferHandler("text"));
		
		button2.addMouseListener(new GlassMouseListener(glass));;
		button2.addMouseMotionListener(new GlassMouseMotionListener(glass));
		button2.setTransferHandler(new TransferHandler("text"));
		
		text.addMouseListener(new GlassMouseListener(glass));
		text.addMouseMotionListener(new GlassMouseMotionListener(glass));
		text.setTransferHandler(new TransferHandler("text"));
		
		label.addMouseListener(new GlassMouseListener(glass));
		label.addMouseMotionListener(new GlassMouseMotionListener(glass));
		label.setTransferHandler(new TransferHandler("text"));
		
		panel1.add(button1);
		panel1.add(label);
		add(panel1, BorderLayout.NORTH);
		
		panel2.add(text);
		panel2.add(button2);
		add(panel2, BorderLayout.SOUTH);
		
		setGlassPane(glass);
		setVisible(true);
	}
	
	public static void main(String [] args) {
		new FrameTest();
	}
}
