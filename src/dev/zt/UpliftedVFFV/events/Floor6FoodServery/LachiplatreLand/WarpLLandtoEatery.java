package dev.zt.UpliftedVFFV.events.Floor6FoodServery.LachiplatreLand;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpLLandtoEatery extends Event {
	
	public static int stagenum = 0;
	public WarpLLandtoEatery(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[448].setOpen(false);
		super.getGamestate().getEvents()[448].setFrames(6);
		super.transport("/Worlds/Floor6FoodServery/FoodCourt/Eatery.txt",34,7,"Food Court");
	}
}
