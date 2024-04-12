package my2dgameTests;


import org.junit.Test;

import entity.Player;
import main.GamePannel;
import tile.TileManager;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.lang.reflect.Field;

public class TileManagerTest {
  
    
        @Test
        public void testDraw() {
            GamePannel gamePannel = new GamePannel();
            Field tileSizeField = null;
            Field playerField = null;
            try {
                tileSizeField = gamePannel.getClass().getDeclaredField("tileSize");
                playerField = gamePannel.getClass().getDeclaredField("player");
                tileSizeField.setAccessible(true);
                playerField.setAccessible(true);
    
                tileSizeField.setInt(gamePannel, 48);
                Player player = new Player(gamePannel, null);
                player.worldX = 100;
                player.worldY = 100;
                playerField.set(gamePannel, player);
    
                TileManager tileManager = new TileManager(gamePannel);
    
                BufferedImage image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
                Graphics2D graphics2D = image.createGraphics();
    
                tileManager.draw(graphics2D);
    
                // Visual inspection or additional assertions can be done here
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            } finally {
                if (tileSizeField != null) {
                    tileSizeField.setAccessible(false);
                }
                if (playerField != null) {
                    playerField.setAccessible(false);
                }
            }
        }
    }
    
  



