package dev.zt.UpliftedVFFV.events.Floor6FoodServery.LachiplatreLand;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpBallpitBluetoLLand extends Event {
	
	public static int stagenum = 0;
	public WarpBallpitBluetoLLand(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[453].setOpen(false);
		super.getGamestate().getEvents()[453].setFrames(6);
		super.transport("/Worlds/Floor6FoodServery/LachiplatreLand/LachiplatreLand1.txt",41,9,"");
	}
}
