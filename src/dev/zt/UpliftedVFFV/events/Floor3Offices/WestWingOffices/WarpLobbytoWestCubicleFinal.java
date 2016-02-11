package dev.zt.UpliftedVFFV.events.Floor3Offices.WestWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpLobbytoWestCubicleFinal extends Event {
	
	public static int stagenum = 0;
	public WarpLobbytoWestCubicleFinal(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
		
	public void run(){
		super.transport("/Worlds/Floor3Offices/WestWingOffices/WestCubicleFinal.txt",22,16,"");
		
	}
}
