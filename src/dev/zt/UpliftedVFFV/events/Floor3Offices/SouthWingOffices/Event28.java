package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;


import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class Event28 extends Event {


	public Event28(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
		
	
	}
	

	
	public void run(){
		super.transport("/Worlds/Floor3Offices/SouthWingOffices/SouthHallRestrooms.txt", 6, 9,"");
	}


}
