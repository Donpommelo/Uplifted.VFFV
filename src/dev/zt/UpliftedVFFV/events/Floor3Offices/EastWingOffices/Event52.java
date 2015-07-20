package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class Event52 extends Event {


	public Event52(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
	}
	
	public void run(){
		super.transport("/Worlds/Floor3Offices/EastWingOffices/EastWingMain.txt", 6,2,"");
	}
}
