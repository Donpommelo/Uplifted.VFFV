package dev.zt.UpliftedVFFV.events.Floor6FoodServery.Processing;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpEmulsifyingtoProcessing1 extends Event {
	
	public static int stagenum = 0;
	public WarpEmulsifyingtoProcessing1(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.transport("/Worlds/Floor6FoodServery/Processing/ProcessingRoom1.txt",4,18,"Processing Room");
	}
}
