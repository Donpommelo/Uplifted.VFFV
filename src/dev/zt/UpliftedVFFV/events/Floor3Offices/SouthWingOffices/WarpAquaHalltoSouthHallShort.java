package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class WarpAquaHalltoSouthHallShort extends Event {

	public static int stagenum = 0;
	public WarpAquaHalltoSouthHallShort(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
	
	public void run(){
		super.transport("/Worlds/Floor3Offices/SouthWingOffices/SouthHallSmall.txt", 12, 8,"South Offices");
	}
	
	public boolean isDoor(){
		return true;
	}
}
