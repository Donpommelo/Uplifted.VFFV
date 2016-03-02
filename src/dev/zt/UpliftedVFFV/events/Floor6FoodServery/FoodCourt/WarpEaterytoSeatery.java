package dev.zt.UpliftedVFFV.events.Floor6FoodServery.FoodCourt;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpEaterytoSeatery extends Event {
	
	public static int stagenum = 0;
	public WarpEaterytoSeatery(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.transport("/Worlds/Floor6FoodServery/FoodCourt/Seatery.txt",8,8,"");
	}
}
