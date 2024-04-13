package my2dgameMocks;
import static org.mockito.Mockito.*;

import java.awt.Graphics2D;

import javax.sound.sampled.Clip;
import javax.swing.JPanel;

import org.junit.jupiter.api.Test;

import main.GamePannel;

public class GamePannelMocking {
    




    @Test
    void testSetupGameWithReturn() {
        GamePannel gamePannelMock = mock(GamePannel.class);

        // Stub the behavior of setupGame method
        doNothing().when(gamePannelMock).setupGame();

        // Call the method
        gamePannelMock.setupGame();

        // Verify that the method was called
        verify(gamePannelMock).setupGame();
    }

    @Test
    void testStartGameThreadWithPatch() {
        GamePannel gamePannelSpy = spy(new GamePannel());

        // Mock the behavior of startGameThread method
        doNothing().when(gamePannelSpy).startGameThread();

        gamePannelSpy.startGameThread();

        verify(gamePannelSpy).startGameThread();
    }

   
}



