package dev.zt.UpliftedVFFV.events.Floor3Offices.WestWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpCubicleDungeonEast extends Event {
	
	public static int stagenum = 0;
	public WarpCubicleDungeonEast(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
		
	public void run(){
		if(!super.getSwitch(26)){
			if(super.getVar(16) == 1){
				super.transport("/Worlds/Floor3Offices/WestWingOffices/WestCubicle.txt",4,18,"");
				super.setVar(16, 2);
			}
			else if(super.getVar(16) == 5){
				super.transport("/Worlds/Floor3Offices/WestWingOffices/WestCubicleFinal.txt",4,16,"");
				super.setVar(16, 0);
				super.setSwitch(26, true);
			}
			else{
				super.transport("/Worlds/Floor3Offices/WestWingOffices/WestCubicle.txt",4,18,"");
				super.setVar(16, 1);
			}
			super.setVar(17, 1);
		}
		else{
			super.transport("/Worlds/Floor3Offices/WestWingOffices/WestCubicleFinal.txt",4,16,"");
		}

	}
}
