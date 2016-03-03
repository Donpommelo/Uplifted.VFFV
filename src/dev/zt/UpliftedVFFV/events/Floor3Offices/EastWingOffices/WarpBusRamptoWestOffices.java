package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpBusRamptoWestOffices extends Event {
	
	public static int stagenum = 0;
	public WarpBusRamptoWestOffices(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
		
	public void run(){
		super.transport("/Worlds/Floor3Offices/WestWingOffices/WestToEastTransition.txt",26,7,"West Offices");
	}
}
