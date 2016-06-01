package dev.zt.UpliftedVFFV.events.Floor6FoodServery.Processing;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpGreenHouseHalltoResynth extends Event {
	
	public static int stagenum = 0;
	public WarpGreenHouseHalltoResynth(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.transport("/Worlds/Floor6FoodServery/Processing/ResynthRoom.txt",25,22,"");
	}
}
