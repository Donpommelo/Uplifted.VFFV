package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class WarpStorageRoomtoSouthHallLong extends Event {


	public WarpStorageRoomtoSouthHallLong(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
		
	}
	
	public void run(){
		super.transport("/Worlds/Floor3Offices/SouthWingOffices/SouthOfficeHallway.txt", 4, 12,"");
	}

}
