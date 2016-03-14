package dev.zt.UpliftedVFFV.events.Floor6FoodServery.Processing;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpHarvestingtoIntroHall extends Event {
	
	public static int stagenum = 0;
	public WarpHarvestingtoIntroHall(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[475].setOpen(false);
		super.getGamestate().getEvents()[475].setFrames(6);
		super.transport("/Worlds/Floor6FoodServery/Processing/IntroHall.txt",16,8,"");
	}
}
