package dev.zt.UpliftedVFFV.events.Floor6FoodServery.LachiplatreLand;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EventCitronGateBack extends Event {
	
	public static int stagenum = 0;
	public EventCitronGateBack(float x, float y, int idnum) {
		super(Assets.Monolith,idnum,x, y, stagenum);
	}

	public void run(){
		super.transport("/Worlds/Floor6FoodServery/LachiplatreLand/LachiplatreLand2.txt",43,8,"");
	}
	
	public boolean isSolid(int i){
		return true;
	}
	
	public boolean isDoor(){
		return true;
	}
	
}
