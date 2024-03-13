package main;

import object.OBJboots;
import object.OBJchest;
import object.OBJdoor;
import object.OBJkey;

public class AssetSetter {
	
	GamePannel gp;
	
	public AssetSetter(GamePannel gp) {
		this.gp=gp;
	}
	
	public void setObject() {
		gp.obj[0]=new OBJkey();
		gp.obj[0].worldX= 23*gp.tileSize;
		gp.obj[0].worldY=7* gp.tileSize;
		
		gp.obj[1]=new OBJkey();
		gp.obj[1].worldX= 23*gp.tileSize;
		gp.obj[1].worldY=40* gp.tileSize;
		
		gp.obj[2]=new OBJkey();
		gp.obj[2].worldX= 37*gp.tileSize;
		gp.obj[2].worldY=7* gp.tileSize;
		
		gp.obj[3]=new OBJdoor();
		gp.obj[3].worldX= 10*gp.tileSize;
		gp.obj[3].worldY=11* gp.tileSize;
		
		gp.obj[4]=new OBJdoor();
		gp.obj[4].worldX= 8*gp.tileSize;
		gp.obj[4].worldY=28* gp.tileSize;
		
		gp.obj[5]=new OBJdoor();
		gp.obj[5].worldX= 12*gp.tileSize;
		gp.obj[5].worldY=22* gp.tileSize;
		
		gp.obj[6]=new OBJchest();
		gp.obj[6].worldX= 10*gp.tileSize;
		gp.obj[6].worldY=7* gp.tileSize;
		
		gp.obj[7]=new OBJboots();
		gp.obj[7].worldX= 37*gp.tileSize;
		gp.obj[7].worldY=42* gp.tileSize;
		
		
		

		
		
	}

}
