package cr;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;

public class PictureWindow {

	private JFrame frame;
	private JTabbedPane tabbedPane;

	/**
	 * Create the application.
	 */
	public PictureWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(2000, 993);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
	}
	
	public void addImg(String path, String tabTitle) {
		JPanel newImg = new JPanel();
		try {
			BufferedImage myPicture = ImageIO.read(new File(path));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			newImg.add(picLabel);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		tabbedPane.addTab(tabTitle, null, newImg, null);
		frame.setVisible(true);
		
		tabbedPane.setSelectedIndex(tabbedPane.indexOfTab(tabTitle));
	}
}
