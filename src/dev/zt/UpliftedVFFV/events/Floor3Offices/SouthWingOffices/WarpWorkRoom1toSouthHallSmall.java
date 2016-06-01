package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;


import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class WarpWorkRoom1toSouthHallSmall extends Event {


	public WarpWorkRoom1toSouthHallSmall(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
	}
	
	public void run(){
		super.transport("/Worlds/Floor3Offices/SouthWingOffices/SouthHallSmall.txt", 4, 24,"");
	}
}
