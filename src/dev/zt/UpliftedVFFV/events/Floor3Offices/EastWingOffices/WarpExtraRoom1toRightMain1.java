package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpExtraRoom1toRightMain1 extends Event {
	
	public static int stagenum = 0;
	public WarpExtraRoom1toRightMain1(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
		
	public void run(){
		super.transport("/Worlds/Floor3Offices/EastWingOffices/EastOfficesRightMain1.txt",12,13,"");
		super.getGamestate().getEvents()[165].setOpen(false);
		super.getGamestate().getEvents()[165].setFrames(6);
	}
}
