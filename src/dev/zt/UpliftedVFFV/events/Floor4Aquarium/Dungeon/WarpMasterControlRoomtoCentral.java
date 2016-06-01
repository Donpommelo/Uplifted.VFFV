package dev.zt.UpliftedVFFV.events.Floor4Aquarium.Dungeon;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpMasterControlRoomtoCentral extends Event {
	
	public static int stagenum = 0;
	public WarpMasterControlRoomtoCentral(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[426].setOpen(false);
		super.getGamestate().getEvents()[426].setFrames(6);
		super.transport("/Worlds/Floor4Aquarium/WetworksDungeon/CentralChamberFullyCleared.txt", 16, 23,"");
	}
}
