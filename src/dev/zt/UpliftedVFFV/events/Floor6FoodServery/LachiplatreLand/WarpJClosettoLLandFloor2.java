package dev.zt.UpliftedVFFV.events.Floor6FoodServery.LachiplatreLand;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpJClosettoLLandFloor2 extends Event {
	
	public static int stagenum = 0;
	public WarpJClosettoLLandFloor2(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[471].setOpen(false);
		super.getGamestate().getEvents()[471].setFrames(6);
		super.transport("/Worlds/Floor6FoodServery/LachiplatreLand/LachiplatreLand2.txt",26,13,"Lachiplatre Land");		
	}
}
