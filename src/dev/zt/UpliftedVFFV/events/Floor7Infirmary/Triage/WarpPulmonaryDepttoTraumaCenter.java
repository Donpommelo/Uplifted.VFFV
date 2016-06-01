package dev.zt.UpliftedVFFV.events.Floor7Infirmary.Triage;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpPulmonaryDepttoTraumaCenter extends Event {
	
	public static int stagenum = 0;
	public WarpPulmonaryDepttoTraumaCenter(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[576].setOpen(false);
		super.getGamestate().getEvents()[576].setFrames(6);
		super.transport("/Worlds/Floor7Infirmary/Triage/TraumaCenter.txt", 22, 7,"Trauma Center");
	}
}
