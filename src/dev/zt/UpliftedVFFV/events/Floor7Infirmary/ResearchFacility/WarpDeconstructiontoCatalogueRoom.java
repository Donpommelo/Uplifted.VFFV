package dev.zt.UpliftedVFFV.events.Floor7Infirmary.ResearchFacility;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpDeconstructiontoCatalogueRoom extends Event {
	
	public static int stagenum = 0;
	public WarpDeconstructiontoCatalogueRoom(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.transport("/Worlds/Floor7Infirmary/ResearchFacility/CatalogueRoom.txt", 10, 9,"Catalogue Room");
	}
}
