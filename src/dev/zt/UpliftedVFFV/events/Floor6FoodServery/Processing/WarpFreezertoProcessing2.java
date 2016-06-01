package dev.zt.UpliftedVFFV.events.Floor6FoodServery.Processing;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpFreezertoProcessing2 extends Event {
	
	public static int stagenum = 0;
	public WarpFreezertoProcessing2(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[490].setOpen(false);
		super.getGamestate().getEvents()[490].setFrames(6);
		super.transport("/Worlds/Floor6FoodServery/Processing/ProcessingRoom2.txt",(int)(gamestate.getPlayer().getPlayerX()/32),7,"Processing Room");
	}
}
