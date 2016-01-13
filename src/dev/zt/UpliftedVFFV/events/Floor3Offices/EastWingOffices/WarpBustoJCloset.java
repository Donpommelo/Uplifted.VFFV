package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;


import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.input.KeyManager;
import dev.zt.UpliftedVFFV.states.GameState;



public class WarpBustoJCloset extends Event {
	
	public static BufferedImage img=Assets.PushDoor1;
	public static int frame;
	public boolean open;
	public static int stagenum = 1;
	public WarpBustoJCloset(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
		frame = 0;
		open = false;
	}

	public void run(){
		switch(this.getstage()){
		case 0: 				
			if(!open){
				open = true;
			}
			else{
				open = false;
			}
			KeyManager.setCutsceneMode(true);
			break;
		case 1:
			KeyManager.setCutsceneMode(false);
			this.setstage(0);
			game.getAudiomanager().playMusic(2, true);
			if(!this.isSelfswitch1()){
				super.setVar(12, super.getVar(12)+1);
				this.setSelfswitch1(true);
			}
			super.transport("/Worlds/Floor3Offices/EastWingOffices/JanitorClosetEast.txt", 5, 10,"Broom Closet");
			open = false;
			break;
		}
		
	}
	
	public void tick(GameState gs) {
		if(open){
			if(frame<6){
				frame++;
			}
			else{
				if(KeyManager.isCutsceneMode() && (int)(gs.getPlayer().getPlayerX()) == 160){
					this.setstage(this.getstage()+1);
					run();
				}	
			}
		}
		else{
			if(frame>0){
				frame--;
			}
			else{
				if(KeyManager.isCutsceneMode() && (int)(gs.getPlayer().getPlayerX()) == 160){
					this.setstage(this.getstage()+1);
					run();
				}	
			}
		}
	}
	
	public void render(Graphics g, int x, int y) {
		switch(frame){
		case 0:
			tex = Assets.PushDoor1;
			break;
		case 2:
			tex = Assets.PushDoor2;
			break;
		case 4:
			tex = Assets.PushDoor3;
			break;
		case 6:
			tex = Assets.PushDoor4;
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
