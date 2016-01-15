package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpBalconytoOuterFloor2 extends Event {
	
	public static int stagenum = 0;
	public WarpBalconytoOuterFloor2(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
		
	public void run(){
		super.transport("/Worlds/Floor3Offices/EastWingOffices/EastOfficesLeftOuterFloor2.txt",20,23,"");
		super.getGamestate().getEvents()[192].setOpen(false);
		super.getGamestate().getEvents()[192].setFrames(6);
	}
}
