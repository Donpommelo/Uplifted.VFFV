package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class Event40 extends Event {


	public Event40(float x, float y, int idnum) {
		super(Assets.SafeOpened,idnum,x, y);
	}
	
	public void run(){
		super.transport("/Worlds/Floor3Offices/SouthWingOffices/ExtraStorageRoom.txt", 3, 3,"South Wing Office");
	}

	public boolean isSolid(int i){
		return true;
	}
}
