package dev.zt.UpliftedVFFV.events.Floor3Offices.WestWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpSperosOfficetoWestCubicleFinal extends Event {
	
	public static int stagenum = 0;
	public WarpSperosOfficetoWestCubicleFinal(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
		
	public void run(){
		super.transport("/Worlds/Floor3Offices/WestWingOffices/WestCubicleFinal.txt",10,47,"");
	}
}
