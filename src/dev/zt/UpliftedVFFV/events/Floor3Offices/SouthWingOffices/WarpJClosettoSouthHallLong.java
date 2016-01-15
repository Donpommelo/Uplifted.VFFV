package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class WarpJClosettoSouthHallLong extends Event {


	public WarpJClosettoSouthHallLong(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
		
	}
	
	public void run(){
		super.getGamestate().getEvents()[34].setOpen(false);
		super.getGamestate().getEvents()[34].setFrames(6);
		super.transport("/Worlds/Floor3Offices/SouthWingOffices/SouthOfficeHallway.txt", 26, 11,"South Offices");
	}

}
