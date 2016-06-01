package dev.zt.UpliftedVFFV.events.Floor4Aquarium.Tunnel;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpEastLobbytoEastTunnel extends Event {
	
	public static int stagenum = 0;
	public WarpEastLobbytoEastTunnel(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		if(!super.getGamestate().getEvents()[701].isSelfswitch2()){
			super.getGamestate().getEvents()[701].run();
		}
		else{
			super.getGamestate().getEvents()[415].setOpen(false);
			super.getGamestate().getEvents()[415].setFrames(6);
			super.transport("/Worlds/Floor4Aquarium/AquariumTunnel/AquariumTunnelEast.txt",31,14,"");
		}
	}
}
