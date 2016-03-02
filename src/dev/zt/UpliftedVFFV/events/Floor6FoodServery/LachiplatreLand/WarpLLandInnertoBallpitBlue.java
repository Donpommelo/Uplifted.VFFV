package dev.zt.UpliftedVFFV.events.Floor6FoodServery.LachiplatreLand;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpLLandInnertoBallpitBlue extends Event {
	
	public static int stagenum = 0;
	public WarpLLandInnertoBallpitBlue(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[463].setOpen(false);
		super.getGamestate().getEvents()[463].setFrames(6);
		super.transport("/Worlds/Floor6FoodServery/LachiplatreLand/LachiplatreLandBallPit2.txt",12,21,"");
	}
}
