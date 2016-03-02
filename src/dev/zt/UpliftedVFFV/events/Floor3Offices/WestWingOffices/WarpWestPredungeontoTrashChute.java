package dev.zt.UpliftedVFFV.events.Floor3Offices.WestWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpWestPredungeontoTrashChute extends Event {
	
	public static int stagenum = 0;
	public WarpWestPredungeontoTrashChute(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
		
	public void run(){
		super.transport("/Worlds/Floor3Offices/WestWingOffices/DumpChute.txt",11,7,"");
	}
}
