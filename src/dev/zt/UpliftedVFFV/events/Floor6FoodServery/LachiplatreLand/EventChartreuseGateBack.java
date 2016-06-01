package dev.zt.UpliftedVFFV.events.Floor6FoodServery.LachiplatreLand;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EventChartreuseGateBack extends Event {
	
	public static int stagenum = 0;
	public EventChartreuseGateBack(float x, float y, int idnum) {
		super(Assets.Monolith,idnum,x, y, stagenum);
	}

	public void run(){
		super.transport("/Worlds/Floor6FoodServery/LachiplatreLand/LachiplatreLand2.txt",17,7,"");
	}
	
	public boolean isSolid(int i){
		return true;
	}
	
	public boolean isDoor(){
		return true;
	}
	
}
