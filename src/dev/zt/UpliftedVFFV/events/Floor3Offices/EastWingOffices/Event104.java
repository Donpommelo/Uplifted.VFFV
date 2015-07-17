package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class Event104 extends Event {


	public Event104(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
	}

	public void run(){
		super.transport("/Worlds/Floor3Offices/EastWingOffices/EastOfficesRightRoom3.txt", 10,17,"");
	}
}
