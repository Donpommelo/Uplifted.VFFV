package dev.zt.UpliftedVFFV.events.Floor7Infirmary.ResearchFacility;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpLaboratorytoConstruction extends Event {
	
	public static int stagenum = 0;
	public WarpLaboratorytoConstruction(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[619].setOpen(false);
		super.getGamestate().getEvents()[619].setFrames(6);
		super.transport("/Worlds/Floor7Infirmary/ResearchFacility/Construction1.txt", 6, 14,"");
	}
}
