package dev.zt.UpliftedVFFV.events.Floor7Infirmary.ResearchFacility;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpAntechambertoFacilityFloor1 extends Event {
	
	public static int stagenum = 0;
	public WarpAntechambertoFacilityFloor1(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.transport("/Worlds/Floor7Infirmary/ResearchFacility/Floor1Main.txt", 20, (int)(gamestate.getPlayer().getPlayerY()/32)+5,"");
	}
}