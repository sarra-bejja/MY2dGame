package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	
	public boolean upPressed,downPressed,leftPressed,rightPressed;

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code=e.getExtendedKeyCode();
		if(code==KeyEvent.VK_UP) {//if user pressed "w" key
			upPressed=true;
			
		}
        else if(code==KeyEvent.VK_DOWN) {
        	downPressed=true;
			
		}
        else if(code==KeyEvent.VK_LEFT) {
        	leftPressed=true;
			
		}
        else if(code==KeyEvent.VK_RIGHT) {
        	rightPressed=true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code=e.getKeyCode();
		if(code==KeyEvent.VK_UP) {//if user pressed "w" key
			upPressed=false;
			
		}
        else if(code==KeyEvent.VK_DOWN) {
        	downPressed=false;
			
		}
        else if(code==KeyEvent.VK_LEFT) {
        	leftPressed=false;
			
		}
        else if(code==KeyEvent.VK_RIGHT) {
        	rightPressed=false;
		}
		
	}

}
