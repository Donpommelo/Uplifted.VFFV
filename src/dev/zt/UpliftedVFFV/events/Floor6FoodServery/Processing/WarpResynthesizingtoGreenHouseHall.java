package dev.zt.UpliftedVFFV.events.Floor6FoodServery.Processing;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpResynthesizingtoGreenHouseHall extends Event {
	
	public static int stagenum = 0;
	public WarpResynthesizingtoGreenHouseHall(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.transport("/Worlds/Floor6FoodServery/Processing/GreenHouseHall.txt",4,16,"");
	}
}
