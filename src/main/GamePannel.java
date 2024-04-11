package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import entity.Player;
import object.SuperObject;
import tile.TileManager;

public class GamePannel extends JPanel implements Runnable{
	//screen settings
	final int originalTilesize=16;//16*16 default size of the player/map tiles/NPCs
    final int scale=3;
    public final int tileSize=originalTilesize*scale;//48*48
    public final int maxScreenCol=16;//window colone
    public final int maxScreenRow=12;//window ligne
    public final int screenWidth= tileSize*maxScreenCol;//768 px
    public final int screenHeight=tileSize*maxScreenRow;//576px
    
    
    //world settings
    public final int maxWorldCol=50;
    public final int maxWorldRow=50;


    


    
    
    //FPS
    int FPS=60;
    //system
    TileManager tileM=new TileManager(this);
    KeyHandler keyH=new KeyHandler();
    public Sound music=new Sound();
    public Sound se=new Sound();
    public CollisionChecker cChecker=new CollisionChecker(this);
    public AssetSetter aSetter =new AssetSetter(this);
    public UI ui=new UI(this);
    Thread gameThread;

    
    //entity and object
    public Player player=new Player(this,keyH);
    public SuperObject obj []= new SuperObject[10];
    

    
    public GamePannel() {
    	this.setPreferredSize(new Dimension(screenWidth,screenHeight));
    	this.setBackground(Color.PINK);
    	this.setDoubleBuffered(true);//for better performance
		this.addKeyListener(keyH);
		this.setFocusable(true);
		
    	
    }
    
    public void setupGame() {
    	aSetter.setObject();
    	PlayMusic(0);
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
		player.update();

		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		//tile
		tileM.draw(g2);
		
		
		
		
		//object
		for(int i=0;i<obj.length;i++) {
			if(obj[i] !=null) {
				obj[i].draw(g2, this);
			}
		}
		
		
		//player
		player.draw(g2);
		
		//UI
		ui.draw(g2);
		
		g2.dispose();
		
		
		
		
	}
	
	public void PlayMusic(int i) {
		music.setFile(i);
		music.play();
		music.loop();
		
	}
	public void stopMusic() {
		if (music.clip != null) {
			music.stop();
		}
	}
	public void playSE(int i) {
		se.setFile(i);
		se.play();
		
	}
    
}





