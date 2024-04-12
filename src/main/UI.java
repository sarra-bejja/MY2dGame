package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import object.OBJkey;

public class UI {
	GamePannel gp;
	Font arial_40,arial_80B;
	public BufferedImage keyImage;
	public boolean messageON=false;
	public String message="";
	int messageCounter=0;
	public boolean gameFinished=false;
	
	double PlayTime;
	
	public UI(GamePannel gp) {
		this.gp=gp;
		arial_40=new Font("Arial",Font.PLAIN,40);
		arial_80B=new Font("Arial",Font.BOLD,80);

		OBJkey key=new OBJkey();
		keyImage =key.image;
	}
	
	public void showMessage(String text) {
		message=text;
		messageON=true;
	}
	
	
	
	public void draw(Graphics2D g2) {
		if(gameFinished==true) {
			
			g2.setFont(arial_40);
			g2.setColor(Color.WHITE);
			
			String text;
			int textlength;
			int x,y;
			
			text="You found the treasure!";
			textlength=(int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x=gp.screenWidth/2-textlength/2;
			y=gp.screenHeight/2-(gp.tileSize*3);
	        drawBorderedString(g2, text, x, y, Color.WHITE, Color.BLACK);
			
			g2.setFont(arial_80B);
			g2.setColor(Color.yellow);
			
			text="Congratulations!";
			textlength=(int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();	
			x=gp.screenWidth/2-textlength/2;
			y=gp.screenHeight/2+(gp.tileSize*3);
	        drawBorderedString(g2, text, x, y, Color.YELLOW, Color.BLACK);
			
			gp.gameThread=null;
		}
		else {
		g2.setFont(arial_40);
		g2.setColor(Color.WHITE);
		g2.drawImage(keyImage,gp.tileSize/2,gp.tileSize/2,gp.tileSize,gp.tileSize,null);
		g2.drawString("x "+gp.player.hasKey,74,65);
		
		//message
		if(messageON==true) {
			g2.setFont(g2.getFont().deriveFont(30F));
			g2.drawString(message,gp.tileSize/2,gp.tileSize*5);
			
			messageCounter++;
			
			if(messageCounter>120) {
				messageCounter=0;
				messageON=false;
			}
		}
		}
	}
	public void drawBorderedString(Graphics2D g2, String text, int x, int y, Color textColor, Color borderColor) {
	    // Draw border
	    g2.setColor(borderColor);
	    for (int i = -2; i <= 2; i++) {
	        for (int j = -2; j <= 2; j++) {
	            g2.drawString(text, x + i, y + j);
	        }
	    }

	    // Draw text
	    g2.setColor(textColor);
	    g2.drawString(text, x, y);
	}

}



