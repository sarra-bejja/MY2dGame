package my2dgameTests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Component;
import java.awt.event.KeyEvent;
import main.KeyHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class keyHandlerTest {
    
    private KeyHandler keyHandler;
    private Component source;

    @BeforeEach
    void setUp() {
        keyHandler = new KeyHandler();
        source = new Component() {};
    }



    @Test
    void testKeyReleased() {
        // Simulate key presses
        keyHandler.keyPressed(new KeyEvent(source, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_UP, 'W'));
        keyHandler.keyPressed(new KeyEvent(source, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_DOWN, 'S'));
        keyHandler.keyPressed(new KeyEvent(source, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_LEFT, 'A'));
        keyHandler.keyPressed(new KeyEvent(source, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_RIGHT, 'D'));

        // Simulate key releases
        keyHandler.keyReleased(new KeyEvent(source, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_UP, 'W'));
        keyHandler.keyReleased(new KeyEvent(source, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_DOWN, 'S'));
        keyHandler.keyReleased(new KeyEvent(source, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_LEFT, 'A'));
        keyHandler.keyReleased(new KeyEvent(source, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_RIGHT, 'D'));

        // Check if the corresponding boolean flags are reset
        assertFalse(keyHandler.upPressed);
        assertFalse(keyHandler.downPressed);
        assertFalse(keyHandler.leftPressed);
        assertFalse(keyHandler.rightPressed);
    }
  
    }





