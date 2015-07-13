package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class EventEmployee1 extends Event {

	public static float xPos,yPos;
	public static BufferedImage img=Assets.EmployeeM1;
	public boolean selfswitch1;
	public int move;
	public EventEmployee1(float x, float y, int idnum) {
		super(img,idnum,x, y);
		xPos=x;
		yPos=y;
		move = 0;
		Event.events[this.getId()].test.runlast = 3;
	}
	

	
	public void run(){
		test.setImgShown(SpriteSorter.SpriteSort(1,Assets.EmployeeM2));
		if (Player.runlast==0){
			Event.events[this.getId()].test.runlast = 1;
		}
		if (Player.runlast==1){
			Event.events[this.getId()].test.runlast = 0;
		}
		if (Player.runlast==2){
			Event.events[this.getId()].test.runlast = 3;
		}
		if (Player.runlast==3){
			Event.events[this.getId()].test.runlast = 2;
		}
		if(selfswitch1==false){
			super.Dialog(38,41,this.getId());
			selfswitch1=true;
		}
		else{
			super.Dialog(42, 42,this.getId());
		}

	}
	
	public void walkCycle(){
		move++;
		if(move >= 200){
			int rand = (int)(Math.random()*4);
			switch(rand){
			case 0:
				super.moveUp();
				break;
			case 1:
				super.moveDown();
				break;
			case 2:
				super.moveLeft();
				 break;
			case 3:
				super.moveRight();
				break;
			}
			move = 0;
		}
	
	}
	
	public boolean isSolid(){
		return true;
	}
	
}
