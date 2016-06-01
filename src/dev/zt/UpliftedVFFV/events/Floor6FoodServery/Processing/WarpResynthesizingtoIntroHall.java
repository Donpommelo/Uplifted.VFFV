package dev.zt.UpliftedVFFV.events.Floor6FoodServery.Processing;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpResynthesizingtoIntroHall extends Event {
	
	public static int stagenum = 0;
	public WarpResynthesizingtoIntroHall(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[476].setOpen(false);
		super.getGamestate().getEvents()[476].setFrames(6);
		super.transport("/Worlds/Floor6FoodServery/Processing/IntroHall.txt",8,8,"Backroom");
		if(!this.isSelfswitch1()){
			this.setSelfswitch1(true);
			super.setQuest(13, 2);
		}
	}
}
