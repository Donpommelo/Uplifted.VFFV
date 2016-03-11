package dev.zt.UpliftedVFFV.events.Floor6FoodServery.Processing;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpProcessing1toHarvesting extends Event {
	
	public static int stagenum = 0;
	public WarpProcessing1toHarvesting(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.transport("/Worlds/Floor6FoodServery/Processing/Harvesting.txt",19,10,"Harvesting");
	}
}
