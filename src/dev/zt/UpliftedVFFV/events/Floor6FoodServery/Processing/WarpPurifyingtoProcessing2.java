package dev.zt.UpliftedVFFV.events.Floor6FoodServery.Processing;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpPurifyingtoProcessing2 extends Event {
	
	public static int stagenum = 0;
	public WarpPurifyingtoProcessing2(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.transport("/Worlds/Floor6FoodServery/Processing/ProcessingRoom2.txt",22,(int)(gamestate.getPlayer().getPlayerY()/32)-1,"Processing Room");
	}
}
