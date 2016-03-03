package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpBusRamptoCarlocsOffice extends Event {
	
	public static int stagenum = 0;
	public WarpBusRamptoCarlocsOffice(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
		
	public void run(){
		super.transport("/Worlds/Floor3Offices/EastWingOffices/EastOfficesCarlocsOfficePlus.txt",17,22,"Carloc's Office");
	}
}
