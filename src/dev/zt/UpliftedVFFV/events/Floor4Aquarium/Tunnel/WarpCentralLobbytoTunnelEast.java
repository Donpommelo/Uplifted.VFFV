package dev.zt.UpliftedVFFV.events.Floor4Aquarium.Tunnel;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpCentralLobbytoTunnelEast extends Event {
	
	public static int stagenum = 0;
	public WarpCentralLobbytoTunnelEast(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.transport("/Worlds/Floor4Aquarium/AquariumTunnel/AquariumTunnelEast.txt",13,(int)(gamestate.getPlayer().getPlayerY()/32)-3,"");
	}
}
