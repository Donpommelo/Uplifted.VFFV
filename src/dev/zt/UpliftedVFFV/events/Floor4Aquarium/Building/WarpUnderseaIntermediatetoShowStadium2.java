package dev.zt.UpliftedVFFV.events.Floor4Aquarium.Building;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpUnderseaIntermediatetoShowStadium2 extends Event {
	
	public static int stagenum = 0;
	public WarpUnderseaIntermediatetoShowStadium2(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.transport("/Worlds/Floor4Aquarium/AquariumBuilding/ShowStadium2.txt",18, 13,"");
	}
}
