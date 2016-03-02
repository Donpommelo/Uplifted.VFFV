package dev.zt.UpliftedVFFV.events.Floor6FoodServery.LachiplatreLand;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpLLandFloor2toInner extends Event {
	
	public static int stagenum = 0;
	public WarpLLandFloor2toInner(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[467].setOpen(false);
		super.getGamestate().getEvents()[467].setFrames(6);
		super.transport("/Worlds/Floor6FoodServery/LachiplatreLand/LachiplatreLand1Inner.txt",13,7,"");
	}
}
