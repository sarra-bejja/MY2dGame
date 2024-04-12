package my2dgameTests;


import org.junit.Test;

import main.GamePannel;
import main.main;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.Assert.*;

public class mainTest {

    @Test
    public void testMain() {
        // Create a new thread to run the main method
        Thread thread = new Thread(() -> {
            try {
                // Run the main method
                main.main(new String[]{});
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Start the thread
        thread.start();

        // Wait for a short period to allow the window to be created
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Get all windows
        Frame[] frames = Frame.getFrames();

        // Find the game window
        JFrame gameWindow = null;
        for (Frame frame : frames) {
            if (frame instanceof JFrame && frame.getTitle().equals("sara's adventure World")) {
                gameWindow = (JFrame) frame;
                break;
            }
        }

        // Verify that the game window is not null
        assertNotNull("Game window is null", gameWindow);

        // Verify that the game window is visible
        assertTrue("Game window is not visible", gameWindow.isVisible());

        // Verify that the game panel is added to the game window
        Component[] components = gameWindow.getContentPane().getComponents();
        boolean gamePanelAdded = false;
        for (Component component : components) {
            if (component instanceof GamePannel) {
                gamePanelAdded = true;
                break;
            }
        }
        assertTrue("Game panel is not added to the game window", gamePanelAdded);

        // Clean up
        gameWindow.dispose();
    }
}



