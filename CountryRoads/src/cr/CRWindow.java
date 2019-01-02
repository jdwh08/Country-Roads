package cr;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.border.EmptyBorder;
import java.io.*;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;

public class CRWindow extends JFrame {

	private JPanel contentPane;
	private static JTabbedPane tabbedPane;
	private static JScrollPane scrollPane;
	private static JTextArea textArea;
	private JLayeredPane layeredPane;
	
	private static int xSize;
	private static int ySize;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		xSize = screenSize.width;
		ySize = screenSize.height;
		
		try {
			CRWindow frame = new CRWindow();
			frame.setVisible(true);
			
			frame.playMusic();
			frame.addLyrics("Almost heaven, ", 6500);
			frame.addLyrics("West Virigina", 3500);
			
			frame.addLyrics("\nBlue Ridge Mountains, ", 3400);
			frame.addImg("mountain.jpg", "Blue Ridge Mountains");
			frame.addLyrics("Shenandoah River,", 2500);
			frame.addImg("river.jpg", "Shenandoah River");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public CRWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Country Roads");
		this.setSize(xSize, ySize);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.NORTH);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 5, xSize/5, ySize - 5);
		layeredPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setBounds(5, 5, xSize/5, ySize - 5);
		scrollPane.add(textArea);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, xSize - 5, ySize - 5);
		layeredPane.add(tabbedPane);
		
		contentPane.setComponentZOrder(textArea, 0);
		contentPane.setComponentZOrder(scrollPane, 1);
		contentPane.setComponentZOrder(tabbedPane, 2);
		contentPane.setComponentZOrder(layeredPane, 3);
	}
	
	/**
	 *  Plays Country Roads
	 */
	
	public void playMusic() {
		try {
			// Open an audio input stream.
			File soundFile = new File("CountryRoads.wav"); // you could also get the sound file with an URL
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			// Get a sound clip resource.
			Clip clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			clip.open(audioIn);
			clip.start();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *  Displays a new line of lyrics.
	 */
	
	public void addLyrics(String lyr, long mstime) throws InterruptedException {		
		TimeUnit.MILLISECONDS.sleep(mstime);
		String currentLyrics = textArea.getText();
		
		currentLyrics += lyr;
		
		textArea.setText(currentLyrics);
	}
	
	/**
	 *  Sets the lyrics to a new string.
	 */
	
	public void setLyrics(String lyr, long mstime) throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(mstime);
		
		textArea = new JTextArea();
		scrollPane.add(textArea);
		textArea.setText(lyr);
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
		tabbedPane.setSelectedIndex(tabbedPane.indexOfTab(tabTitle));
	}
}
