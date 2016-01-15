package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpBustoRamp extends Event {
	
	public static int stagenum = 0;
	public WarpBustoRamp(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
		
	public void run(){
		super.transport("/Worlds/Floor3Offices/EastWingOffices/EastWingOutside.txt", 31,39,"");
		super.getGamestate().getEvents()[203].setOpen(false);
		super.getGamestate().getEvents()[203].setFrames(6);
	}
}
