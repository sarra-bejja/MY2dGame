package my2dgameMocks;

import static org.mockito.Mockito.*;

import java.awt.Graphics2D;

import main.GamePannel;
import tile.TileManager;

import org.junit.jupiter.api.Test;

public class TileManagerMocking {



    @Test
    void testGetTileImage() {
        // Create a mock of GamePannel
        GamePannel gpMock = mock(GamePannel.class);

        // Create a mock of TileManager
        TileManager tileManagerMock = mock(TileManager.class);

        // Stub the behavior of getTileImage method
        doNothing().when(tileManagerMock).getTileImage();

        // Call the method
        tileManagerMock.getTileImage();

        // Verify that the method was called
        verify(tileManagerMock).getTileImage();
    }

    @Test
    void testLoadMapWithPatch() {
        GamePannel gpMock = mock(GamePannel.class);
        TileManager tileManager = spy(new TileManager(gpMock)); // Create a spy instead of a real instance
    
        // Mock the behavior of loadMap method
        doNothing().when(tileManager).loadMap(anyString());
    
        tileManager.loadMap("/maps/testMap.txt");
    
        verify(tileManager).loadMap("/maps/testMap.txt");
    }
    

    @Test
    void testDrawWithSideEffects() {
        GamePannel gpMock = mock(GamePannel.class);
        TileManager tileManager = spy(new TileManager(gpMock)); // Create a spy instead of a real instance
    
        // Mock the behavior of draw method
        doAnswer(invocation -> {
            Graphics2D g2 = (Graphics2D) invocation.getArguments()[0];
        
            return null;
        }).when(tileManager).draw(any(Graphics2D.class));
    
        tileManager.draw(mock(Graphics2D.class));
    
        verify(tileManager).draw(any(Graphics2D.class));
    }
    
    
}




