package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class Event5 extends Event {


	public Event5(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
	}
		
	public void run(){
		super.transport("/Worlds/Floor3Offices/SouthWingOffices/EastWing.txt", 12, 21,"South Wing Offices");
	}
}
