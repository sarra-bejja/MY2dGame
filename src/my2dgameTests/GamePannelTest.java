package my2dgameTests;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.GamePannel;


public class GamePannelTest {
  
    private GamePannel gamePanel;

    @BeforeEach
    void setUp() {
        gamePanel = new GamePannel();
    }



    @Test
    void testPlayMusic() {
        gamePanel.PlayMusic(0);
        assertNotNull(gamePanel.music.clip);
    }

    @Test
    void testStopMusic() {
        gamePanel.stopMusic();
        assertNull(gamePanel.music.clip);
    }

    @Test
    void testPlaySE() {
        gamePanel.playSE(0);
        assertNotNull(gamePanel.se.clip);
    }
}



