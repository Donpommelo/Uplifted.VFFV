package dev.zt.UpliftedVFFV.events.Floor4Aquarium.Building;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpLeftExhibitHalltoLobby extends Event {
	
	public static int stagenum = 0;
	public WarpLeftExhibitHalltoLobby(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[374].setOpen(false);
		super.getGamestate().getEvents()[374].setFrames(6);
		super.transport("/Worlds/Floor4Aquarium/AquariumBuilding/SouthLobby.txt",7,21,"");
		
	}
}
