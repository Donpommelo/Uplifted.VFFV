package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpInnerRightoRightBasement extends Event {
	
	public static int stagenum = 0;
	public WarpInnerRightoRightBasement(float x, float y, int idnum) {
		super(Assets.LadderDown,idnum,x, y, stagenum);
	}
		
	public void run(){
		super.transport("/Worlds/Floor3Offices/EastWingOffices/EastOfficesRightMain2.txt",23,20,"");
		
	}
	
	public int renderBelow(){
		return -1;
	}
}
