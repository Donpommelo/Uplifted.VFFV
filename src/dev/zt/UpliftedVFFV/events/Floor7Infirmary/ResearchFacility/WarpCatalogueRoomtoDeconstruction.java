package dev.zt.UpliftedVFFV.events.Floor7Infirmary.ResearchFacility;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpCatalogueRoomtoDeconstruction extends Event {
	
	public static int stagenum = 0;
	public WarpCatalogueRoomtoDeconstruction(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.transport("/Worlds/Floor7Infirmary/ResearchFacility/Deconstruction1.txt", 4, 9,"");
	}
}
