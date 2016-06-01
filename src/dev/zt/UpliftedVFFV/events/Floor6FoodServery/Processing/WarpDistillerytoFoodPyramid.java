package dev.zt.UpliftedVFFV.events.Floor6FoodServery.Processing;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpDistillerytoFoodPyramid extends Event {
	
	public static int stagenum = 0;
	public WarpDistillerytoFoodPyramid(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[504].setOpen(false);
		super.getGamestate().getEvents()[504].setFrames(6);
		super.transport("/Worlds/Floor6FoodServery/Processing/FoodPyramid.txt",5,12,"Food Pyramid");
	}
}
