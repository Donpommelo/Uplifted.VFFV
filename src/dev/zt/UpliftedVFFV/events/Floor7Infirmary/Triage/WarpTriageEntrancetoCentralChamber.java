package dev.zt.UpliftedVFFV.events.Floor7Infirmary.Triage;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpTriageEntrancetoCentralChamber extends Event {
	
	public static int stagenum = 0;
	public WarpTriageEntrancetoCentralChamber(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.transport("/Worlds/Floor7Infirmary/Triage/TriageCentralChamber.txt", 3, 19,"");
	}
}
