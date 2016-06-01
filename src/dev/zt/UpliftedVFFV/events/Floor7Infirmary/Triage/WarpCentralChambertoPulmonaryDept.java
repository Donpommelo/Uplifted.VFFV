package dev.zt.UpliftedVFFV.events.Floor7Infirmary.Triage;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpCentralChambertoPulmonaryDept extends Event {
	
	public static int stagenum = 0;
	public WarpCentralChambertoPulmonaryDept(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.transport("/Worlds/Floor7Infirmary/Triage/PulmonaryDept.txt", 4, 16,"Pulmonary Department");
	}
}