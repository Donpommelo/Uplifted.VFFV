package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpRightBasementtoShop extends Event {
	
	public static int stagenum = 0;
	public WarpRightBasementtoShop(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
		
	public void run(){
		super.transport("/Worlds/Floor3Offices/EastWingOffices/EastOfficesRightMain2Room3.txt",11,12,"A Suspicious Room . . .");
		
	}
}
