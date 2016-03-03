package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpAtriaFloor2toAtriaFloor1 extends Event {
	
	public static int stagenum = 0;
	public WarpAtriaFloor2toAtriaFloor1(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
		
	public void run(){
		super.transport("/Worlds/Floor3Offices/EastWingOffices/EastOfficesLeftAtria.txt", 12, 8,"Atrium");
	}
}
