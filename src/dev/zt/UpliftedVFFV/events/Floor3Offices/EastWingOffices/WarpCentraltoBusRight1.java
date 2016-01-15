package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpCentraltoBusRight1 extends Event {
	
	public static int stagenum = 0;
	public WarpCentraltoBusRight1(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
		
	public void run(){
		super.transport("/Worlds/Floor3Offices/EastWingOffices/EastWingMainHall.txt",8,6,"");
		super.getGamestate().getEvents()[147].setOpen(false);
		super.getGamestate().getEvents()[147].setFrames(6);
	}
}
