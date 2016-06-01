package dev.zt.UpliftedVFFV.events.Floor6FoodServery.Processing;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpIntroHalltoEatery extends Event {
	
	public static int stagenum = 0;
	public WarpIntroHalltoEatery(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.transport("/Worlds/Floor6FoodServery/FoodCourt/Eatery.txt",27,13,"Food Court");
	}
}
