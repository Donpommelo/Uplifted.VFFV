package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class WarpSouthHallLongtoMailroom extends Event {


	public WarpSouthHallLongtoMailroom(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
		
	}
		
	public void run(){
		super.transport("/Worlds/Floor3Offices/SouthWingOffices/Mailroom.txt", 4, 12,"Mailroom");
	
	}
	
	public boolean isSolid(){
		return !Event.getEvents()[66].isSelfswitch1();
	}
	
}
