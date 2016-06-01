package dev.zt.UpliftedVFFV.events.Floor4Aquarium.Tunnel;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpTunneltoSouthLobby extends Event {
	
	public static int stagenum = 0;
	public WarpTunneltoSouthLobby(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[373].setOpen(false);
		super.getGamestate().getEvents()[373].setFrames(6);
		super.transport("/Worlds/Floor4Aquarium/AquariumBuilding/SouthLobby.txt",19,7,"Aquarium Building");
		
	}
}
