package dev.zt.UpliftedVFFV.events.Floor7Infirmary.ResearchFacility;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpConstructiontoFacilityFloor2 extends Event {
	
	public static int stagenum = 0;
	public WarpConstructiontoFacilityFloor2(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.transport("/Worlds/Floor7Infirmary/ResearchFacility/Floor2Main.txt", 17, 24,"Upper Facility");
	}
}
