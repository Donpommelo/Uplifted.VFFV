package dev.zt.UpliftedVFFV.events.Floor7Infirmary.ResearchFacility;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpJClosettoFacilityFloor1 extends Event {
	
	public static int stagenum = 0;
	public WarpJClosettoFacilityFloor1(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[587].setOpen(false);
		super.getGamestate().getEvents()[587].setFrames(6);
		super.transport("/Worlds/Floor7Infirmary/ResearchFacility/Floor1Main.txt", 11, 15,"Research Facility");
	}
}
