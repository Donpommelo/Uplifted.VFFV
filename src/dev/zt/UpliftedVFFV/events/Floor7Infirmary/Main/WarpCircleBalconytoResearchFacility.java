package dev.zt.UpliftedVFFV.events.Floor7Infirmary.Main;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpCircleBalconytoResearchFacility extends Event {
	
	public static int stagenum = 0;
	public WarpCircleBalconytoResearchFacility(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.transport("/Worlds/Floor7Infirmary/ResearchFacility/Antechamber.txt", 10, (int)(gamestate.getPlayer().getPlayerY()/32)-6,"Research Facility");
	}
}
