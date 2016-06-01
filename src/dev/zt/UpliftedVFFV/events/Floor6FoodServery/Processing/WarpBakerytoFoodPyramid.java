package dev.zt.UpliftedVFFV.events.Floor6FoodServery.Processing;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpBakerytoFoodPyramid extends Event {
	
	public static int stagenum = 0;
	public WarpBakerytoFoodPyramid(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[502].setOpen(false);
		super.getGamestate().getEvents()[502].setFrames(6);
		super.transport("/Worlds/Floor6FoodServery/Processing/FoodPyramid.txt",8,26,"Food Pyramid");
	}
}
