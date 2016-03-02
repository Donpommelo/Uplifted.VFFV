package dev.zt.UpliftedVFFV.events.Floor3Offices.WestWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpWestOfficesIntrotoPredungeon extends Event {
	
	public static int stagenum = 0;
	public WarpWestOfficesIntrotoPredungeon(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
		
	public void run(){
		super.transport("/Worlds/Floor3Offices/WestWingOffices/WestOfficePreDungeon.txt",18,13,"");
	}
}
