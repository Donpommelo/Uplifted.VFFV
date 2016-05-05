package dev.zt.UpliftedVFFV.events.Floor6FoodServery.FoodCourt;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.input.KeyManager;
import dev.zt.UpliftedVFFV.world.EventManager;

public class EventWaitressCutscene extends Event {

	public static float xPos,yPos;
	public static int stagenum=7;		
	public static BufferedImage img=Assets.EmployeeF;
	public EventWaitressCutscene(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
		xPos=x;
		yPos=y;
		this.test.runlast = 3;
	}
	
	public void run(){	
		test.setImgShown(SpriteSorter.SpriteSort(1,Assets.EmployeeF));
		if (Player.runlast==0){
			this.test.runlast = 1;
		}
		if (Player.runlast==1){
			this.test.runlast = 0;
		}
		if (Player.runlast==2){
			this.test.runlast = 3;
		}
		if (Player.runlast==3){
			this.test.runlast = 2;
		}
			
		switch(this.getstage()){
		case 0: 
			super.moveLeft();
			break;
		case 1:
			super.moveLeft();
			break;
		case 2:
			super.moveLeft();
			break;
		case 3:
			super.moveLeft();
			break;
		case 4:
			super.moveLeft();

			break;
		case 5:
			super.moveLeft();

			break;
		case 6:		
			super.moveLeft();

			break;
		case 7:
			break;
			}
	}
	
	public boolean isSolid(int i){
		return true;
	}
	
	public boolean drawn(){
		return !this.isSelfswitch1();
	}
	
	public boolean loaded(){
		return !this.isSelfswitch1();
	}
}
