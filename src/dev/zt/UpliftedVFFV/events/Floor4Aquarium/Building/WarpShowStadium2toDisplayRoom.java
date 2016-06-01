package dev.zt.UpliftedVFFV.events.Floor4Aquarium.Building;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpShowStadium2toDisplayRoom extends Event {
	
	public static int stagenum = 0;
	public WarpShowStadium2toDisplayRoom(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[398].setOpen(false);
		super.getGamestate().getEvents()[398].setFrames(6);
		super.transport("/Worlds/Floor4Aquarium/AquariumBuilding/DisplayCaseRoom.txt",13,7,"");
	}
}
