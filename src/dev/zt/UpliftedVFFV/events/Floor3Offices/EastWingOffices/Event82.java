package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class Event82 extends Event {


	public Event82(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);	
	}
	
	public void run(){
		super.transport("/Worlds/Floor3Offices/EastWingOffices/EastOfficesLeftMain2Room2.txt", 8,7,"");
	}
	
	public boolean isSolid(){
		return false;
	}

}
