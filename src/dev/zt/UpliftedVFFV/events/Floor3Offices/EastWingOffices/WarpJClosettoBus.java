package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpJClosettoBus extends Event {
	
	public static int stagenum = 0;
	public WarpJClosettoBus(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
		
	public void run(){
		super.transport("/Worlds/Floor3Offices/EastWingOffices/EastWingMainHall.txt",5,6,"East Offices");
		super.getGamestate().getEvents()[146].setOpen(false);
		super.getGamestate().getEvents()[146].setFrames(6);
	}
}
