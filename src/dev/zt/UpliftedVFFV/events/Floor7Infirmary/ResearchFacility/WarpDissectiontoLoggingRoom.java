package dev.zt.UpliftedVFFV.events.Floor7Infirmary.ResearchFacility;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpDissectiontoLoggingRoom extends Event {
	
	public static int stagenum = 0;
	public WarpDissectiontoLoggingRoom(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.transport("/Worlds/Floor7Infirmary/ResearchFacility/LoggingRoom.txt", 27, 12,"Logging Room");
	}
}
