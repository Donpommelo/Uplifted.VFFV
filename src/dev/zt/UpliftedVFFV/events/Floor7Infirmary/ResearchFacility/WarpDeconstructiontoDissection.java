package dev.zt.UpliftedVFFV.events.Floor7Infirmary.ResearchFacility;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpDeconstructiontoDissection extends Event {
	
	public static int stagenum = 0;
	public WarpDeconstructiontoDissection(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[611].setOpen(false);
		super.getGamestate().getEvents()[611].setFrames(6);
		super.transport("/Worlds/Floor7Infirmary/ResearchFacility/DissectionRoom.txt", 34, 7,"Dissection Room");
	}
}
