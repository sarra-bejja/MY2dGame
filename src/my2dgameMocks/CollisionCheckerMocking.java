package my2dgameMocks;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import entity.Entity;
import main.CollisionChecker;
import main.GamePannel;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CollisionCheckerMocking {
 

    @Test
    void testCheckObjectWithMockSideEffect() {
        // Create mocks
        GamePannel gpMock = mock(GamePannel.class);
        Entity entityMock = mock(Entity.class);
        CollisionChecker collisionCheckerMock = mock(CollisionChecker.class);
    
        // Use Mock/side_effect technique to mock the behavior of checkObject method
        doReturn(999).when(collisionCheckerMock).checkObject(entityMock, true);
    
        // Call the checkObject method on the mock CollisionChecker
        collisionCheckerMock.checkObject(entityMock, true);
    
        // Verify that the checkObject method was called
        verify(collisionCheckerMock).checkObject(entityMock, true);
    }
    
}