package dev.zt.UpliftedVFFV.events.Floor7Infirmary.ResearchFacility;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpWeavingRoomtoConstruction extends Event {
	
	public static int stagenum = 0;
	public WarpWeavingRoomtoConstruction(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[620].setOpen(false);
		super.getGamestate().getEvents()[620].setFrames(6);
		super.transport("/Worlds/Floor7Infirmary/ResearchFacility/Construction1.txt", 18, 24,"");
	}
}
