package dev.zt.UpliftedVFFV.events.Floor7Infirmary.ResearchFacility;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpFacilityFloor1toImpalefier extends Event {
	
	public static int stagenum = 0;
	public WarpFacilityFloor1toImpalefier(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[597].setOpen(false);
		super.getGamestate().getEvents()[597].setFrames(6);
		super.transport("/Worlds/Floor7Infirmary/ResearchFacility/ImpalefierRoom.txt", 6, 7,"");
	}
}
