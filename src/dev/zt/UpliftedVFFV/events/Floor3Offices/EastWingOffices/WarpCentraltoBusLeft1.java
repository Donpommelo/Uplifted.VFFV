package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpCentraltoBusLeft1 extends Event {
	
	public static int stagenum = 0;
	public WarpCentraltoBusLeft1(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
		
	public void run(){
		if(super.getQuest(3) < 2){
			super.transport("/Worlds/Floor3Offices/EastWingOffices/EastWingMainHall.txt",11,6,"East Hallway");
		}
		else{
			super.transport("/Worlds/Floor3Offices/EastWingOffices/EastWingMainHall.txt",11,6,"East Shuttle");
		}
		super.getGamestate().getEvents()[148].setOpen(false);
		super.getGamestate().getEvents()[148].setFrames(6);
	}
}
