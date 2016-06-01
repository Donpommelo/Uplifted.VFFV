package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpFacadetoLobby extends Event {
	
	public static int stagenum = 0;
	public WarpFacadetoLobby(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
		
	public void run(){
		super.transport("/Worlds/Floor3Offices/EastWingOffices/EastWingLobby.txt", (int)(gamestate.getPlayer().getPlayerX()/32)+3,7,"");
		
	}
}
