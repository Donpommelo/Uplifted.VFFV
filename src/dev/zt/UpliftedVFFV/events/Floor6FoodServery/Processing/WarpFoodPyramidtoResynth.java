package dev.zt.UpliftedVFFV.events.Floor6FoodServery.Processing;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpFoodPyramidtoResynth extends Event {
	
	public static int stagenum = 0;
	public WarpFoodPyramidtoResynth(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[497].setOpen(false);
		super.getGamestate().getEvents()[497].setFrames(6);
		super.transport("/Worlds/Floor6FoodServery/Processing/ResynthRoom.txt",7,13,"Resynthesizing Room");
	}
}
