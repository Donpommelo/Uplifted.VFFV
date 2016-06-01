package dev.zt.UpliftedVFFV.events.Floor6FoodServery.Processing;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpProcessing1toEmulsifying extends Event {
	
	public static int stagenum = 0;
	public WarpProcessing1toEmulsifying(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.transport("/Worlds/Floor6FoodServery/Processing/EmulsifyingRoom.txt",17,18,"Emulsification Room");
	}
}
