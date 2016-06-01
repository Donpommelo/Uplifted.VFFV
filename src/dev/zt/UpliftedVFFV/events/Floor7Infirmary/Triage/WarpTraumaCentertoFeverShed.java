package dev.zt.UpliftedVFFV.events.Floor7Infirmary.Triage;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpTraumaCentertoFeverShed extends Event {
	
	public static int stagenum = 0;
	public WarpTraumaCentertoFeverShed(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[574].setOpen(false);
		super.getGamestate().getEvents()[574].setFrames(6);
		super.transport("/Worlds/Floor7Infirmary/Triage/FeverShed.txt", 21, 7,"Fever Shed");
	}
}
