package dev.zt.UpliftedVFFV.events.Floor6FoodServery.LachiplatreLand;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpLLandtoFloor2 extends Event {
	
	public static int stagenum = 0;
	public WarpLLandtoFloor2(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.transport("/Worlds/Floor6FoodServery/LachiplatreLand/LachiplatreLand2.txt",12,22,"");
	}
}
