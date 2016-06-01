package dev.zt.UpliftedVFFV.events.Floor6FoodServery.FoodCourt;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpEaterytoProcessing extends Event {
	
	public static int stagenum = 0;
	public WarpEaterytoProcessing(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		if(super.getGamestate().getEvents()[753].isSelfswitch1()){
			super.transport("/Worlds/Floor6FoodServery/Processing/IntroHall.txt",21,10,"Backroom");
		}
		else{
			super.getGamestate().getEvents()[753].run();
		}
	}
	
	public boolean isSolid(int i){
		return true;
	}
	
	public boolean isDoor(){
		return true;
	}
}
