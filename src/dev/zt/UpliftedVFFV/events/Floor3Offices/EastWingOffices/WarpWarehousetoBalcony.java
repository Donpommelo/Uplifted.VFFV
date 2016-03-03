package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpWarehousetoBalcony extends Event {
	
	public static int stagenum = 0;
	public WarpWarehousetoBalcony(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
		
	public void run(){
		super.transport("/Worlds/Floor3Offices/EastWingOffices/EastOfficesLeftBalcony.txt",23,20,"East Balcony");
		super.getGamestate().getEvents()[195].setOpen(false);
		super.getGamestate().getEvents()[195].setFrames(6);
	}
}
