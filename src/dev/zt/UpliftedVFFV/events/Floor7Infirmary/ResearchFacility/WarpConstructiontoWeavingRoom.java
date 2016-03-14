package dev.zt.UpliftedVFFV.events.Floor7Infirmary.ResearchFacility;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.input.KeyManager;
import dev.zt.UpliftedVFFV.states.GameState;



public class WarpConstructiontoWeavingRoom extends Event {

	public static BufferedImage img=Assets.ClearDoor1;

	public static int stagenum = 1;
	public WarpConstructiontoWeavingRoom(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}	

	
	public void run(){
		switch(this.getstage()){
		case 0: 				
			if(!this.isOpen()){
				this.setOpen(true);
			}
			else{
				this.setOpen(false);
			}
			KeyManager.setCutsceneMode(true);
			break;
		case 1:
			KeyManager.setCutsceneMode(false);
			this.setstage(0);
			super.transport("/Worlds/Floor7Infirmary/ResearchFacility/WeavingRoom.txt",7,16,"Loom");
			this.setOpen(false);
			this.setFrames(0);
			break;
		}
	}

	public void tick(GameState gs) {
		if(this.isOpen()){
			if(this.getFrames()<6){
				this.setFrames(this.getFrames()+1);
			}
			else{
				if(KeyManager.isCutsceneMode() && gs.getPlayer().getPlayerX()== 576 && gs.getPlayer().getPlayerY() == 768){
					this.setstage(this.getstage()+1);
					run();
				}	
			}
		}
		else{
			if(this.getFrames()>0){
				this.setFrames(this.getFrames()-1);
			}
			else{
				if(KeyManager.isCutsceneMode() && gs.getPlayer().getPlayerX() == 576 && gs.getPlayer().getPlayerY() == 768){
					this.setstage(this.getstage()+1);
					run();
				}	
			}
		}
	}
	
	public void render(Graphics g, int x, int y) {
		switch(this.getFrames()){
		case 0:
			tex = Assets.ClearDoor1;
			break;
		case 2:
			tex = Assets.ClearDoor2;
			break;
		case 4:
			tex = Assets.ClearDoor3;
			break;
		case 6:
			tex = Assets.ClearDoor4;
			break;
		}
		g.drawImage(tex,x, y-32, tex.getWidth(), tex.getHeight(), null);
	}
	
	public boolean isDoor(){
		return true;
	}
	
	public boolean isSolid(int i){
		return true;
	}

}
