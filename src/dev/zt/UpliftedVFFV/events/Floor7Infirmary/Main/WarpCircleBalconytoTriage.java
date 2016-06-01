package dev.zt.UpliftedVFFV.events.Floor7Infirmary.Main;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpCircleBalconytoTriage extends Event {
	
	public static int stagenum = 0;
	public WarpCircleBalconytoTriage(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.transport("/Worlds/Floor7Infirmary/Triage/TriageEntrance.txt", 4, 8,"Triage");
	}
}
