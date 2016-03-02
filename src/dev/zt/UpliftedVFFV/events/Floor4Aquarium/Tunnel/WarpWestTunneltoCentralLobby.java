package dev.zt.UpliftedVFFV.events.Floor4Aquarium.Tunnel;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpWestTunneltoCentralLobby extends Event {
	
	public static int stagenum = 0;
	public WarpWestTunneltoCentralLobby(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.transport("/Worlds/Floor4Aquarium/AquariumTunnel/CentralChamber.txt",14,(int)(gamestate.getPlayer().getPlayerY()/32)+5,"");
		
	}
	
	public boolean isDoor(){
		return true;
	}
}
