package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class Event14 extends Event {


	public Event14(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
		
	
	}
	

	
	public void run(){
		super.transport("/Worlds/Floor3Offices/SouthWingOffices/Lobby.txt", 13, 4,"South Lobby");
	}

}
