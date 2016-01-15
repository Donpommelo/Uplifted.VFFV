package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpStairsRoomtoAtria extends Event {
	
	public static int stagenum = 0;
	public WarpStairsRoomtoAtria(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
		
	public void run(){
		super.transport("/Worlds/Floor3Offices/EastWingOffices/EastOfficesLeftAtria.txt",6,13,"");
		super.getGamestate().getEvents()[184].setOpen(false);
		super.getGamestate().getEvents()[184].setFrames(6);
	}
}
