package my2dgameTests;


    import static org.junit.jupiter.api.Assertions.assertEquals;
    import static org.junit.jupiter.api.Assertions.assertNotNull;
    import main.AssetSetter;
    import main.GamePannel;
    
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.Test;
    
    public class AssetSetterTest {
        private GamePannel gp;
        private AssetSetter assetSetter;
    
        @BeforeEach
        void setUp() {
            gp = new GamePannel();
            assetSetter = new AssetSetter(gp);
        }
    
        @Test
        void testSetObject() {
            assetSetter.setObject();
    
            // Check that objects are set at specific indices
            assertNotNull(gp.obj[0]);
            assertNotNull(gp.obj[1]);
            assertNotNull(gp.obj[2]);
            assertNotNull(gp.obj[3]);
            assertNotNull(gp.obj[4]);
            assertNotNull(gp.obj[5]);
            assertNotNull(gp.obj[6]);
            assertNotNull(gp.obj[7]);
    
            // Check the world coordinates of some objects
            assertEquals(23 * gp.tileSize, gp.obj[0].worldX);
            assertEquals(7 * gp.tileSize, gp.obj[0].worldY);
    
            assertEquals(37 * gp.tileSize, gp.obj[2].worldX);
            assertEquals(7 * gp.tileSize, gp.obj[2].worldY);
    
            assertEquals(10 * gp.tileSize, gp.obj[3].worldX);
            assertEquals(11 * gp.tileSize, gp.obj[3].worldY);
    
            assertEquals(8 * gp.tileSize, gp.obj[4].worldX);
            assertEquals(28 * gp.tileSize, gp.obj[4].worldY);
        }
    }
    




