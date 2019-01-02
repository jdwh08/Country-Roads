package cr;

import java.io.*;
import javax.sound.sampled.*;
import javax.swing.*;

// To play sound using Clip, the process need to be alive.
// Hence, we use a Swing application.
public class SoundClipTest extends JFrame {

	private static final long serialVersionUID = -8344443022010624636L;

	// Constructor
	public SoundClipTest() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Country Roads");
		this.setSize(800, 450);
		this.setVisible(true);
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

	public static void main(String[] args) {
		new SoundClipTest();
	}
}
