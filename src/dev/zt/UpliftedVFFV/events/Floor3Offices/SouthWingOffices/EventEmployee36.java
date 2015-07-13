package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventEmployee36 extends Event {

	public boolean selfswitch1=false;
	public static BufferedImage img=SpriteSorter.SpriteSort(10,Assets.EmployeeF);
	public EventEmployee36(float x, float y, int idnum) {
		super(img,idnum,x, y);
		
	
	}
	

	
	public void run(){
		if(!selfswitch1){
			super.Dialog(217, 230,this.getId());
			selfswitch1 = true;
		}
		else{
			super.Dialog(231, 231,this.getId());
			
		}
	
	}


	
	public boolean isSolid(){
		return true;
	}
}
