package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class GamePannel extends JPanel implements Runnable{
	//screen settings
	final int originalTilesize=16;//16*16 default size of the player/map tiles/NPCs
    final int scale=3;
    final int tileSize=originalTilesize*scale;//48*48
    final int maxScreenCol=16;//window colone
    final int maxScreenRow=12;//window ligne
    final int screenWidth= tileSize*maxScreenCol;//768 px
    final int screenHeight=tileSize*maxScreenRow;//576px
    
    //FPS
    int FPS=60;
    KeyHandler keyH=new KeyHandler();
    Thread gameThread;
    
    //set player's default position
    int playerX=100;
    int playerY=100;
    int playerSpeed=4;
    
    public GamePannel() {
    	this.setPreferredSize(new Dimension(screenWidth,screenHeight));
    	this.setBackground(Color.pink);
    	this.setDoubleBuffered(true);//for better performance
		this.addKeyListener(keyH);
		this.setFocusable(true);
		
    	
    }
    
    public void startGameThread() {
    	gameThread=new Thread(this);
    	gameThread.start();
    }

	@Override //game loop(delta method)
	public void run() {
		
		double drawInterval=1000000000/FPS; //0.01666 seconds
		double delta=0;
		double lastTime=System.nanoTime();
		double currentTime;
		
		
		while(gameThread !=null) {
			//1-update information: such as character positions
			//2-draw: draw the screen with updated informations
			currentTime=System.nanoTime();
			delta+=(currentTime-lastTime)/drawInterval;
			lastTime=currentTime;
			if(delta>=1) {
			
			update();
			repaint();
			delta--;
			
			}	
		}
		
	}
	
	public void update() {
		if(keyH.upPressed==true) {
			playerY-=playerSpeed;
		}
		else if(keyH.downPressed==true) {
			playerY+=playerSpeed;
		}
		else if(keyH.leftPressed==true) {
			playerX-=playerSpeed;
		}
		else if(keyH.rightPressed==true) {
			playerX+=playerSpeed;
		}
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		g2.setColor(Color.white);
		g2.fillRect(playerX,playerY,tileSize, tileSize);
		g2.dispose();
		
		
	}
    
}
