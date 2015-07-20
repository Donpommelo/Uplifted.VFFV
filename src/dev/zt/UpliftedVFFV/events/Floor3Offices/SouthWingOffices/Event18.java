package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class Event18 extends Event {


	public Event18(float x, float y, int idnum) {
		super(Assets.Stairs,idnum,x, y);
	}
	
	public void run(){
		super.transport("/Worlds/Floor3Offices/SouthWingOffices/SouthHallSmall.txt", 3, 3,"3rd Floor Hallway");
	}
}
