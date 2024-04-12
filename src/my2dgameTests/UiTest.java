package my2dgameTests;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.junit.Test;

import main.GamePannel;
import main.UI;

import static org.junit.Assert.*;

public class UiTest {

    @Test
    public void testDraw() {
        // Create a new UI instance
        GamePannel gp = new GamePannel();
        UI ui = new UI(gp);

        // Create a BufferedImage for the key image
        BufferedImage keyImage = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);

        // Set the key image in the UI instance
        ui.keyImage = keyImage;

        // Create a BufferedImage for testing
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        // Call the draw method
        ui.draw(g2d);

        // Compare the key image pixels with the corresponding pixels in the test image
        for (int y = 0; y < keyImage.getHeight(); y++) {
            for (int x = 0; x < keyImage.getWidth(); x++) {
                assertEquals(keyImage.getRGB(x, y), image.getRGB(x, y));
            }
        }

        // Cleanup
        g2d.dispose();
    }
}



