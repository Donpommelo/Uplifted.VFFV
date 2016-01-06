package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpCentraltoBusLeft2 extends Event {
	
	public static int stagenum = 0;
	public WarpCentraltoBusLeft2(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
		
	public void run(){
		//change bus stop location
		super.transport("/Worlds/Floor3Offices/EastWingOffices/EastWingMainHall.txt",5,10,"");
		
	}
}
