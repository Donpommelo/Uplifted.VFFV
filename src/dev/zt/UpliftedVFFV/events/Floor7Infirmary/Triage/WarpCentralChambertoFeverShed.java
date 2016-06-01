package dev.zt.UpliftedVFFV.events.Floor7Infirmary.Triage;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpCentralChambertoFeverShed extends Event {
	
	public static int stagenum = 0;
	public WarpCentralChambertoFeverShed(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[572].setOpen(false);
		super.getGamestate().getEvents()[572].setFrames(6);
		super.transport("/Worlds/Floor7Infirmary/Triage/FeverShed.txt", 6, 7,"Fever Shed");
	}
}
