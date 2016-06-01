package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpOuterFloor2toAtria extends Event {
	
	public static int stagenum = 0;
	public WarpOuterFloor2toAtria(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
		
	public void run(){
		super.transport("/Worlds/Floor3Offices/EastWingOffices/EastOfficesLeftAtria.txt",25,9,"");
		super.getGamestate().getEvents()[185].setOpen(false);
		super.getGamestate().getEvents()[185].setFrames(6);
	}
}
