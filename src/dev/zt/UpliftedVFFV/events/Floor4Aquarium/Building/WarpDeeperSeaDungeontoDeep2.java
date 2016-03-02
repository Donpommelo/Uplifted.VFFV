package dev.zt.UpliftedVFFV.events.Floor4Aquarium.Building;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpDeeperSeaDungeontoDeep2 extends Event {
	
	public static int stagenum = 0;
	public WarpDeeperSeaDungeontoDeep2(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[389].setOpen(false);
		super.getGamestate().getEvents()[389].setFrames(6);
		super.transport("/Worlds/Floor4Aquarium/AquariumBuilding/DeepSeaDungeon.txt",22,7,"");
		
	}
}
