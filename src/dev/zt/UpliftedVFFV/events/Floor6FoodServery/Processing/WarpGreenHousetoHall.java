package dev.zt.UpliftedVFFV.events.Floor6FoodServery.Processing;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpGreenHousetoHall extends Event {
	
	public static int stagenum = 0;
	public WarpGreenHousetoHall(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[511].setOpen(false);
		super.getGamestate().getEvents()[511].setFrames(6);
		super.transport("/Worlds/Floor6FoodServery/Processing/GreenHouseHall.txt",16,7,"Resynthesis Room");
	}
}
