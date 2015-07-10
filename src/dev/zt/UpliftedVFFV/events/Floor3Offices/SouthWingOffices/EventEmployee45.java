package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EventEmployee45 extends Event {

	public boolean selfswitch1=false;
	public static BufferedImage img=SpriteSorter.SpriteSort(4,Assets.EmployeeF);
	public EventEmployee45(float x, float y, int idnum) {
		super(img,idnum,x, y);
		
	
	}
		
	public void run(){
		if (Player.runlast==0){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(1,Assets.EmployeeF));
		}
		if (Player.runlast==1){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(10,Assets.EmployeeF));
		}
		if (Player.runlast==2){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(7,Assets.EmployeeF));
		}
		if (Player.runlast==3){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(4,Assets.EmployeeF));
		}

			super.Dialog(281, 282,this.getId());		

	}

	public boolean isSolid(){
		return true;
	}
	
}
