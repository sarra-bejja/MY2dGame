package my2dgameTests;
import static org.junit.jupiter.api.Assertions.*;
    
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.Player;
import main.GamePannel;
import main.KeyHandler;

public class PlayerTest {

    
   
        private Player player;
        private GamePannel gamePannel;
        private KeyHandler keyHandler;
    
        @BeforeEach
        void setUp() {
            gamePannel = new GamePannel();
            keyHandler = new KeyHandler();
            player = new Player(gamePannel, keyHandler);
        }
    
        @Test
        void testPlayerCreation() {
            assertNotNull(player);
        }
    
        @Test
        void testDefaultValues() {
            assertEquals(gamePannel.tileSize*23, player.worldX);
            assertEquals(gamePannel.tileSize*21, player.worldY);
            assertEquals(4, player.speed);
            assertEquals("down", player.direction);
        }
    
        
    
    

}



