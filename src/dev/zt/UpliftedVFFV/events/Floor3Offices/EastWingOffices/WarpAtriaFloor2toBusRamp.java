package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpAtriaFloor2toBusRamp extends Event {
	
	public static int stagenum = 0;
	public WarpAtriaFloor2toBusRamp(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
		
	public void run(){
		super.transport("/Worlds/Floor3Offices/EastWingOffices/EastWingOutside.txt", 25, 17,"Bus Ramp");
		super.getGamestate().getEvents()[201].setOpen(false);
		super.getGamestate().getEvents()[201].setFrames(6);
	}
}
