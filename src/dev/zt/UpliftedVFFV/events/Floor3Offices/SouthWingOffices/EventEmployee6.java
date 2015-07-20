package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EventEmployee6 extends Event {

	public static float xPos,yPos;
	public static BufferedImage img=Assets.EmployeeM2;
	public boolean selfswitch1;
	public int move;
	public EventEmployee6(float x, float y, int idnum) {
		super(img,idnum,x, y);
		xPos=x;
		yPos=y;
		move = 0;
		Event.events[this.getId()].test.runlast = 1;
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
			super.Dialog(72, 73,this.getId());
			selfswitch1=true;
		}
		else{
			super.Dialog(73, 73,this.getId());
		}
	}
	
	public void walkCycle(){
		move++;
		if(move >= 250){
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

	public boolean isSolid(int i){
		return true;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public void setX(float x) {
		this.x = x;
	}
}
