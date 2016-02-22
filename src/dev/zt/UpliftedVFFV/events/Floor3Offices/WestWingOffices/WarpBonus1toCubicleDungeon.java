package dev.zt.UpliftedVFFV.events.Floor3Offices.WestWingOffices;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpBonus1toCubicleDungeon extends Event {
	
	public static int stagenum = 0;
	public WarpBonus1toCubicleDungeon(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
		
	public void run(){
		super.transport("/Worlds/Floor3Offices/WestWingOffices/WestCubicle.txt",15,7,"");
		super.getGamestate().getEvents()[282].setOpen(false);
		super.getGamestate().getEvents()[282].setFrames(6);
	}
}
