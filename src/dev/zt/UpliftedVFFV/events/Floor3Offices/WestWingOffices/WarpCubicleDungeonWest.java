package dev.zt.UpliftedVFFV.events.Floor3Offices.WestWingOffices;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpCubicleDungeonWest extends Event {
	
	public static int stagenum = 0;
	public WarpCubicleDungeonWest(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
		
	public void run(){
		if(!super.getSwitch(26)){
			super.transport("/Worlds/Floor3Offices/WestWingOffices/WestCubicle.txt",22,16,"");
			if(super.getVar(16) == 4){
				super.setVar(16, 5);
			}
			else{
				super.setVar(16, 2);
			}
		}
		else{
			super.transport("/Worlds/Floor3Offices/WestWingOffices/WestBonusRoom2.txt",9,9,"");
		}

	}
}
