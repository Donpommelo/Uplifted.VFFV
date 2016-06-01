package dev.zt.UpliftedVFFV.events.Floor4Aquarium.Building;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpShowStadium2toUnderseaIntermediate extends Event {
	
	public static int stagenum = 0;
	public WarpShowStadium2toUnderseaIntermediate(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.transport("/Worlds/Floor4Aquarium/AquariumBuilding/UnderwaterIntermediate.txt",22, 5,"");
	}
}
