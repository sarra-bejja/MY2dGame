package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJdoor extends SuperObject {
	public OBJdoor() {
		
		name="door";
		try {
			image=ImageIO.read(getClass().getResourceAsStream("/objects/door.png"));
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision=true;
		

	}
}
