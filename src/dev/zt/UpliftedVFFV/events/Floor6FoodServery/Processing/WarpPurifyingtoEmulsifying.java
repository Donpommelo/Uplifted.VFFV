package dev.zt.UpliftedVFFV.events.Floor6FoodServery.Processing;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpPurifyingtoEmulsifying extends Event {
	
	public static int stagenum = 0;
	public WarpPurifyingtoEmulsifying(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[483].setOpen(false);
		super.getGamestate().getEvents()[483].setFrames(6);
		super.transport("/Worlds/Floor6FoodServery/Processing/EmulsifyingRoom.txt",10,26,"Emulsification Room");
	}
}
