package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpCarlocsHalltoStairsRoom extends Event {
	
	public static int stagenum = 0;
	public WarpCarlocsHalltoStairsRoom(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
		
	public void run(){
		super.transport("/Worlds/Floor3Offices/EastWingOffices/EastOfficesLeft1Room1.txt",10,7,"");
		super.getGamestate().getEvents()[188].setOpen(false);
		super.getGamestate().getEvents()[188].setFrames(6);
	}
}
