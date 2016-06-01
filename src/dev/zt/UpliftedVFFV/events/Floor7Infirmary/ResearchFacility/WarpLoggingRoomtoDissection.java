package dev.zt.UpliftedVFFV.events.Floor7Infirmary.ResearchFacility;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpLoggingRoomtoDissection extends Event {
	
	public static int stagenum = 0;
	public WarpLoggingRoomtoDissection(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.transport("/Worlds/Floor7Infirmary/ResearchFacility/DissectionRoom.txt", 12, 11,"Dissection Room");
	}
}
