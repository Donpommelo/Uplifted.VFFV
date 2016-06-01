package dev.zt.UpliftedVFFV.events.Floor4Aquarium.Dungeon;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpJClosettoDrainRoom extends Event {
	
	public static int stagenum = 0;
	public WarpJClosettoDrainRoom(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[429].setOpen(false);
		super.getGamestate().getEvents()[429].setFrames(6);
		
		super.transport("/Worlds/Floor4Aquarium/WetworksDungeon/DrainRoom.txt", 10, 7,"");

	}
}
