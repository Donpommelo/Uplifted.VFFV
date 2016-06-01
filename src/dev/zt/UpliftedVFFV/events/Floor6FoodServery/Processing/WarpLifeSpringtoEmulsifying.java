package dev.zt.UpliftedVFFV.events.Floor6FoodServery.Processing;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpLifeSpringtoEmulsifying extends Event {
	
	public static int stagenum = 0;
	public WarpLifeSpringtoEmulsifying(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[484].setOpen(false);
		super.getGamestate().getEvents()[484].setFrames(6);
		super.transport("/Worlds/Floor6FoodServery/Processing/EmulsifyingRoom.txt",5,7,"Emulsification Room");
	}
}
