package dev.zt.UpliftedVFFV.events.Floor3Offices.WestWingOffices;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.input.KeyManager;
import dev.zt.UpliftedVFFV.states.GameState;



public class WarpCubicleDungeonNorthEx extends Event {

	public static BufferedImage img=Assets.ClearDoor1;
	public static int stagenum = 1;
	public WarpCubicleDungeonNorthEx(float x, float y, int idnum) {
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
			game.getAudiomanager().playMusic(2, true);
			if(super.getVar(16) >= 9){
				super.transport("/Worlds/Floor3Offices/WestWingOffices/WestCubicleFinalFinal.txt",13,28,"");
			}
			else{
				super.transport("/Worlds/Floor3Offices/WestWingOffices/WestCubicleExtended.txt",13,28,"");
				if(super.getVar(18) == 3 || (super.getVar(18) == 4 && super.getVar(17) == 3) ||
						(super.getVar(18) == 5 && super.getVar(17) == 0) || (super.getVar(18) == 6 && super.getVar(17) == 1)
						|| (super.getVar(18) == 7 && super.getVar(17) == 2)){
					super.setVar(16, super.getVar(16)+1);
				}
				else{
					super.setVar(16, 1);
				}
				super.setVar(17, 3);
				super.setVar(18, (int)(Math.random()*8));
			}
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
				if(KeyManager.isCutsceneMode() && (int)(gs.getPlayer().getPlayerX()) == 416){
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
				if(KeyManager.isCutsceneMode() && (int)(gs.getPlayer().getPlayerX()) == 416){
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
