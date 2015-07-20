package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class Event85 extends Event {


	public Event85(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
	}
	
	public void run(){
		super.transport("/Worlds/Floor3Offices/EastWingOffices/EastOfficesLeftMain1Room1.txt", 4,7,"");
	}
}
