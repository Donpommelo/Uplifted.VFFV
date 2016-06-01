package dev.zt.UpliftedVFFV.events.Floor4Aquarium.Dungeon;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpMazetoCloggedRoom extends Event {
	
	public static int stagenum = 0;
	public WarpMazetoCloggedRoom(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){		
		super.transport("/Worlds/Floor4Aquarium/WetworksDungeon/BlockedPipeRoom.txt", 27, 14,"");

	}
}
