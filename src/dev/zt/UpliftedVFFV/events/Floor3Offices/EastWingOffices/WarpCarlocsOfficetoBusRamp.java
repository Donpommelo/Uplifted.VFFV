package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpCarlocsOfficetoBusRamp extends Event {
	
	public static int stagenum = 0;
	public WarpCarlocsOfficetoBusRamp(float x, float y, int idnum) {
		super(Assets.LadderUp,idnum,x, y, stagenum);
	}
		
	public void run(){
		super.transport("/Worlds/Floor3Offices/EastWingOffices/EastWingOutside.txt",20,13,"Bus Ramp");
	}
	
	public boolean drawn(){
		if(super.getQuest(5) > 3){
			return true;
		}
		else{
			return false;
		}
	}
}
