package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpBustoWherever extends Event {
	
	public static int stagenum = 0;
	public WarpBustoWherever(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
		
	public void run(){
		super.transport("/Worlds/Floor3Offices/EastWingOffices/EastWingMain.txt",5,7,"");
		super.getGamestate().getEvents()[144].setOpen(false);
		super.getGamestate().getEvents()[144].setFrames(6);		
	}
}
