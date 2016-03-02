package dev.zt.UpliftedVFFV.events.Floor7Infirmary.Triage;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpCentralChambertoBurnWard extends Event {
	
	public static int stagenum = 0;
	public WarpCentralChambertoBurnWard(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[570].setOpen(false);
		super.getGamestate().getEvents()[570].setFrames(6);
		super.transport("/Worlds/Floor7Infirmary/Triage/BurnWard.txt", 6, 6,"Burn Ward");
	}
}
