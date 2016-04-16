package dev.zt.UpliftedVFFV.events.Floor6FoodServery.FoodCourt;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.input.KeyManager;
import dev.zt.UpliftedVFFV.states.GameState;



public class WarpEaterytoLLand extends Event {

	public static BufferedImage img=Assets.ClearDoor1;

	public static int stagenum = 1;
	public WarpEaterytoLLand(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}	

	
	public void run(){
		if(this.isSelfswitch1()){
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
				super.transport("/Worlds/Floor6FoodServery/LachiplatreLand/LachiplatreLand1.txt",6,32,"Lachiplatre Land");
				this.setOpen(false);
				this.setFrames(0);
				break;
			}
		}
		else{
			if(super.getQuest(3) == 5){
				Dialog[] d = new Dialog[8];
				d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You produce the Shrinking Ray that the Informant gave you./");
				d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",1,"Uh, do you think this is safe? To use this on myself?");
				d[2] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"I don't see why not.");
				d[3] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"Well, here goes nothing!/Firing in one...two.../three!");
				d[4] = new Dialog("Operator","/CharacterBusts/Player-1.png",1,"...");
				d[5] = new Dialog("Operator","/CharacterBusts/Player-1.png",1,"Did...you use it?/I don't feel any different...");
				d[6] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"Would you look at that!/The door opens now!/We should be on our way.");
				d[7] = new Dialog("Operator","/CharacterBusts/Player-1.png",1,"...");
				super.Dialog(d,7, this.getId(), true);
				this.setSelfswitch1(true);
				super.transport("/Worlds/Floor6FoodServery/LachiplatreLand/LachiplatreLand1.txt",6,32,"Lachiplatre Land");
			}
			else{
				Dialog[] d = new Dialog[2];
				d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"A mysterious force prevents you from entering the door./");
				d[1] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"A sign reads: 'Play place NOT for adults! Management asks that employees stop skipping work to play in the jungle gym.'");
				super.Dialog(d,1, this.getId(), true);
			}
			this.setstage(1);
		}
		
		
	}

	public void tick(GameState gs) {
		if(this.isOpen()){
			if(this.getFrames()<6){
				this.setFrames(this.getFrames()+1);
			}
			else{
				if(KeyManager.isCutsceneMode() && gs.getPlayer().getPlayerX()== 1088){
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
				if(KeyManager.isCutsceneMode() && gs.getPlayer().getPlayerX() == 1088){
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
