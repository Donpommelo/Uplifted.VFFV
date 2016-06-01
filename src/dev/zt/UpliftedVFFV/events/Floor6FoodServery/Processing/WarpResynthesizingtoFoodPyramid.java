package dev.zt.UpliftedVFFV.events.Floor6FoodServery.Processing;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.input.KeyManager;
import dev.zt.UpliftedVFFV.states.GameState;



public class WarpResynthesizingtoFoodPyramid extends Event {

	public static BufferedImage img=Assets.ClearDoor1;

	public static int stagenum = 1;
	public WarpResynthesizingtoFoodPyramid(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}	

	
	public void run(){
		if(super.getQuest(13) >1){
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
				super.transport("/Worlds/Floor6FoodServery/Processing/FoodPyramid.txt",28,41,"Food Pyramid");
				this.setOpen(false);
				this.setFrames(0);
				break;
			}
		}
		else{
			Dialog[] d2 = new Dialog[1];
			d2[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"The door is locked.");
			super.Dialog(d2, 0, this.getId(), true);
			this.setstage(1);
		}
		
	}

	public void tick(GameState gs) {
		if(this.isOpen()){
			if(this.getFrames()<6){
				this.setFrames(this.getFrames()+1);
			}
			else{
				if(KeyManager.isCutsceneMode() && gs.getPlayer().getPlayerX()== 224){
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
				if(KeyManager.isCutsceneMode() && gs.getPlayer().getPlayerX() == 224){
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
