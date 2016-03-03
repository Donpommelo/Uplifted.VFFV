package dev.zt.UpliftedVFFV.events.Floor3Offices.WestWingOffices;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpCubicleDungeonSouth extends Event {
	
	public static int stagenum = 0;
	public WarpCubicleDungeonSouth(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
		
	public void run(){
		if(!super.getSwitch(26)){
			super.transport("/Worlds/Floor3Offices/WestWingOffices/WestCubicle.txt",15,7,"");
			super.getGamestate().getEvents()[282].setOpen(false);
			super.getGamestate().getEvents()[282].setFrames(6);
			super.setVar(16, 1);
			super.setVar(17, 0);
		}
		else{
			super.transport("/Worlds/Floor3Offices/WestWingOffices/WestOfficePreDungeon.txt",10,8,"");
			super.getGamestate().getEvents()[277].setOpen(false);
			super.getGamestate().getEvents()[277].setFrames(6);
		}

	}
}
