package my2dgameMocks;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentCaptor.forClass;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Player;
import main.GamePannel;
import main.KeyHandler;

public class PlayerMocking {


 
    @Test
    public void testPlayerMock() {
        // Create a mock object of the Player class
        Player player = mock(Player.class);
    
        // Set up a stubbing with no return value
        doNothing().when(player).update();
    
        // Call the update() method on the mock object
        player.update();
    
        
    }
    
    @Test
    public void testPlayerSpy() {
        // Mock GamePannel and KeyHandler
        GamePannel gp = mock(GamePannel.class);
        KeyHandler keyH = mock(KeyHandler.class);
    
        // Create a spy object of the Player class
        Player spyPlayer = spy(new Player(gp, keyH));
    
        // Call the draw() method on the spy object with a mocked Graphics2D object
        spyPlayer.draw(mock(Graphics2D.class));
    
        // Verify that the draw() method was called
        verify(spyPlayer).draw(any(Graphics2D.class));
    }
    

    
}
