package dev.zt.UpliftedVFFV.events.Floor4Aquarium.Building;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpDeepSeaDungeontoDeeper1 extends Event {
	
	public static int stagenum = 0;
	public WarpDeepSeaDungeontoDeeper1(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.transport("/Worlds/Floor4Aquarium/AquariumBuilding/DeeperSeaDungeon.txt",11,38,"");
		
	}
}
