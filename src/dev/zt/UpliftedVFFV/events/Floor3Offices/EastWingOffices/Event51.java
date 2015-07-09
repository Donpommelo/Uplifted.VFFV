package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class Event51 extends Event {


	public Event51(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
		
	
	}
		
	public void run(){
		super.transport("/Worlds/Floor3Offices/EastWingOffices/EastWingMainHall.txt", 3,8,"");
	}

	
	public boolean isSolid(){
		return false;
	}

}
