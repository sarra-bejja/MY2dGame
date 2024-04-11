package my2dgameTests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertNull;
import main.Sound;

public class SoundTest {
     private Sound sound;

    @BeforeEach
    void setUp() {
        sound = new Sound();
    }

        @Test
        void testSetFile() {
            Sound sound = new Sound();
    
            for (int i = 0; i < sound.soundURL.length; i++) {
                sound.setFile(i);
                assertNotNull(sound.clip);
            }
        }
        @Test
        void testPlay() {
            Sound sound = new Sound();
            for (int i = 0; i < sound.soundURL.length; i++) {
                sound.setFile(i);
                sound.play();
                // Wait for the clip to finish playing
                while (sound.clip.isRunning()) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                assertNotNull(sound.clip);
                sound.stop(); // Stop the sound after testing
                assertNull(sound.clip);
            }
        }
    
        @Test
        void testLoop() {
            sound.setFile(0); // Assuming index 0 has a valid sound file
    
            if (sound.clip == null) {
                fail("Failed to load sound file");
            }
    
            sound.loop();
    
            // Wait for a short time to allow the clip to start looping
            try {
                Thread.sleep(500); // 500 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    
            assertTrue(sound.clip.isRunning(), "Clip is not running after calling loop");
    
            // Stop the loop and cleanup
            sound.stop();
        }
    
        @Test
        void testStop() {
            Sound sound = new Sound();
            for (int i = 0; i < sound.soundURL.length; i++) {
                sound.setFile(i);
                sound.play(); // Start playing the sound
                sound.stop(); // Stop the sound
                assertNull(sound.clip); // Clip should be null after stopping
            }
        }
    
       

        }
    
    
            
        
        

