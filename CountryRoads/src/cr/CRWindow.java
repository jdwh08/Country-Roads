package cr;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.io.*;
import java.util.concurrent.TimeUnit;

import javax.sound.sampled.*;
import javax.swing.*;

public class CRWindow extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private static JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PictureWindow pics = new PictureWindow();
			CRWindow frame = new CRWindow();
			frame.setVisible(true);
			
			frame.playMusic();
			frame.addLyrics("Almost heaven, ", 6500);
			frame.addLyrics("West Virigina", 3500);
			
			frame.addLyrics("\nBlue Ridge Mountains, ", 3400);
			pics.addImg("mountain.jpg", "Blue Ridge Mountains");
			frame.addLyrics("Shanandoah River,", 2500);
			pics.addImg("river.jpg", "Shenandoah River");

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
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
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		textArea.setText(currentLyrics);
	}
	
	/**
	 *  Sets the lyrics to a new string.
	 */
	
	public void setLyrics(String lyr, long mstime) throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(mstime);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		textArea.setText(lyr);
	}
}
