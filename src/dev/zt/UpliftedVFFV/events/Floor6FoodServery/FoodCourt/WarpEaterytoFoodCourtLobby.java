package dev.zt.UpliftedVFFV.events.Floor6FoodServery.FoodCourt;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpEaterytoFoodCourtLobby extends Event {
	
	public static int stagenum = 0;
	public WarpEaterytoFoodCourtLobby(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[442].setOpen(false);
		super.getGamestate().getEvents()[442].setFrames(6);
		super.transport("/Worlds/Floor6FoodServery/FoodCourt/SouthLobby.txt",22,7,"");
	}
}
