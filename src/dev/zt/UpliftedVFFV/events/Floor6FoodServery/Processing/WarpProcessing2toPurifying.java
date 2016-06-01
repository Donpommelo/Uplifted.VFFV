package dev.zt.UpliftedVFFV.events.Floor6FoodServery.Processing;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpProcessing2toPurifying extends Event {
	
	public static int stagenum = 0;
	public WarpProcessing2toPurifying(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.transport("/Worlds/Floor6FoodServery/Processing/PurifyingRoom.txt",4,(int)(gamestate.getPlayer().getPlayerY()/32)+1,"Purification Room");
	}
}
