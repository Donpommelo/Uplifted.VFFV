package dev.zt.UpliftedVFFV.events.Floor7Infirmary.ResearchFacility;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpDissectiontoEOP extends Event {
	
	public static int stagenum = 0;
	public WarpDissectiontoEOP(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[617].setOpen(false);
		super.getGamestate().getEvents()[617].setFrames(6);
		super.transport("/Worlds/Floor7Infirmary/ResearchFacility/ExaminationofParts.txt", 21, 7,"Examination of Parts");
	}
}
