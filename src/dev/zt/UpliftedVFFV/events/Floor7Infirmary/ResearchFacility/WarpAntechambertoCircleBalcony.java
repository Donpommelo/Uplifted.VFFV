package dev.zt.UpliftedVFFV.events.Floor7Infirmary.ResearchFacility;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpAntechambertoCircleBalcony extends Event {
	
	public static int stagenum = 0;
	public WarpAntechambertoCircleBalcony(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.transport("/Worlds/Floor7Infirmary/CircleBalcony.txt", 4, (int)(gamestate.getPlayer().getPlayerY()/32)+6,"Infirmary");
	}
}
