package dev.zt.UpliftedVFFV.events.Floor7Infirmary.Triage;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpHospicetoCentralChamber extends Event {
	
	public static int stagenum = 0;
	public WarpHospicetoCentralChamber(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[568].setOpen(false);
		super.getGamestate().getEvents()[568].setFrames(6);
		super.transport("/Worlds/Floor7Infirmary/Triage/TriageCentralChamber.txt", 11, 7,"");
	}
}
