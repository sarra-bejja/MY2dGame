package main;



	import java.net.URL;

	import javax.sound.sampled.AudioInputStream;
	import javax.sound.sampled.AudioSystem;
	import javax.sound.sampled.Clip;

	public class Sound {

		public Clip clip;//to open audiofile
		public URL soundURL[]=new URL[30];//to store the path of the soundfiles
		
		
		public Sound() {
			soundURL[0]=getClass().getResource("/sound/SaraAdventure.wav");
			soundURL[1]=getClass().getResource("/sound/coin.wav");
			soundURL[2]=getClass().getResource("/sound/powerup.wav");
			soundURL[3]=getClass().getResource("/sound/unlock.wav");
			soundURL[4]=getClass().getResource("/sound/fanfare.wav");


		}
		public void setFile(int i) {
			try {
				AudioInputStream ais=AudioSystem.getAudioInputStream(soundURL[i]);
				clip=AudioSystem.getClip();
				clip.open(ais);
				
			}catch(Exception e) {
				
			}
			
		}
		public void play() {
			if (clip != null) {
				clip.start();
			} else {
				System.out.println("No file set. Call setFile() before playing.");
			}
			
		}
		public void loop() {
			if (clip != null) {
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			}
		}
		public void stop() {
			clip.stop();
			clip.close(); // Close the clip
			clip = null; // Set clip to null after stopping
			
		}
	}