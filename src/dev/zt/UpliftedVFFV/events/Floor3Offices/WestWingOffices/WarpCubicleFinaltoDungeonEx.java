package dev.zt.UpliftedVFFV.events.Floor3Offices.WestWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpCubicleFinaltoDungeonEx extends Event {
	
	public static int stagenum = 0;
	public WarpCubicleFinaltoDungeonEx(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
		
	public void run(){
		if(!super.getSwitch(27)){
			super.setVar(16, 1);
			super.setVar(17, 1);
			super.setVar(18, (int)(Math.random()*8));
			super.transport("/Worlds/Floor3Offices/WestWingOffices/WestCubicleExtended.txt",22,16,"");
		}
		else{
			super.transport("/Worlds/Floor3Offices/WestWingOffices/Lobby.txt",4,8,"");
		}
		
	}
}
