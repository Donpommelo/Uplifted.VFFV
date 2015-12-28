package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;


import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class WarpMailroomtoSouthHallLong extends Event {


	public WarpMailroomtoSouthHallLong(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
		
	}
		
	public void run(){
		super.transport("/Worlds/Floor3Offices/SouthWingOffices/SouthOfficeHallway.txt", 29, 11,"");
	}
	
	public boolean isSolid(){
		return !Event.events[66].isSelfswitch1();
	}
	
}
