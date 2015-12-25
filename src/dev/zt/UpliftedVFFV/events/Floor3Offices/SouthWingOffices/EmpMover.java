package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EmpMover extends Event {

	public boolean selfswitch1=false;
	public static BufferedImage img=SpriteSorter.SpriteSort(7,Assets.EmployeeM2);
	public EmpMover(float x, float y, int idnum) {
		super(img,idnum,x, y);
	}
		
	public void run(){
		if (Player.runlast==0){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(1,Assets.EmployeeM2));
		}
		if (Player.runlast==1){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(10,Assets.EmployeeM2));
		}
		if (Player.runlast==2){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(7,Assets.EmployeeM2));
		}
		if (Player.runlast==3){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(4,Assets.EmployeeM2));
		}
		if(selfswitch1==false){
			super.Dialog(43, 49,this.getId());
			selfswitch1=true;
		}
		else{
			super.Dialog(50, 50,this.getId());
		}

	}
	
	public boolean isSolid(int i){
		return true;
	}
	
	public boolean drawn(){
		return !super.getSwitch(2);
	}
}
