package dev.zt.UpliftedVFFV.events.Floor7Infirmary.ResearchFacility;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpDissectiontoSieveRoom extends Event {
	
	public static int stagenum = 0;
	public WarpDissectiontoSieveRoom(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.transport("/Worlds/Floor7Infirmary/ResearchFacility/SieveRoom.txt", 3, 24,"Sieve Room");
	}
}
