package dev.zt.UpliftedVFFV.events.Floor4Aquarium.Tunnel;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpJClosettoCentralLobby extends Event {
	
	public static int stagenum = 0;
	public WarpJClosettoCentralLobby(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[411].setOpen(false);
		super.getGamestate().getEvents()[411].setFrames(6);
		super.transport("/Worlds/Floor4Aquarium/AquariumTunnel/CentralChamber.txt",18,14,"");
		
	}
}
