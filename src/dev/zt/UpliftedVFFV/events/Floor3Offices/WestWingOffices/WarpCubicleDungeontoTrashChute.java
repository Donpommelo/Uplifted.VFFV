package dev.zt.UpliftedVFFV.events.Floor3Offices.WestWingOffices;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpCubicleDungeontoTrashChute extends Event {
	
	public static int stagenum = 2;
	public WarpCubicleDungeontoTrashChute(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
		
	public void run(){
		switch(this.getstage()){
		case 0:
			super.fite(24, this.getId(), false,true);
			break;
		case 1:
			super.transport("/Worlds/Floor3Offices/WestWingOffices/DumpChute.txt",9,37,"");
			super.setVar(16, 0);
			super.Timer(this.getId(), 10);
			break;
		case 2:
			this.setstage(0);
			super.screenShake(25);
			break;
		}
		
	}
}
