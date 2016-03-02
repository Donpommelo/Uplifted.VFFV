package dev.zt.UpliftedVFFV.events.Floor7Infirmary.Triage;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpCentralChambertoTriageEntrance extends Event {
	
	public static int stagenum = 0;
	public WarpCentralChambertoTriageEntrance(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.transport("/Worlds/Floor7Infirmary/Triage/TriageEntrance.txt", 20, 14,"");
	}
}
