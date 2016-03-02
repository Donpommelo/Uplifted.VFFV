package dev.zt.UpliftedVFFV.events.Floor4Aquarium.Building;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpDeepestSeaDungeontoDeeper extends Event {
	
	public static int stagenum = 0;
	public WarpDeepestSeaDungeontoDeeper(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[392].setOpen(false);
		super.getGamestate().getEvents()[392].setFrames(6);
		super.transport("/Worlds/Floor4Aquarium/AquariumBuilding/DeeperSeaDungeon.txt",17,7,"");
		
	}
}
