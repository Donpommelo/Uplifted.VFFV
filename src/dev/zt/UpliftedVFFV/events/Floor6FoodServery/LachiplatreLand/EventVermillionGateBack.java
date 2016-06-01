package dev.zt.UpliftedVFFV.events.Floor6FoodServery.LachiplatreLand;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EventVermillionGateBack extends Event {
	
	public static int stagenum = 0;
	public EventVermillionGateBack(float x, float y, int idnum) {
		super(Assets.Monolith,idnum,x, y, stagenum);
	}

	public void run(){
		super.transport("/Worlds/Floor6FoodServery/LachiplatreLand/LachiplatreLand2.txt",36,17,"");
	}
	
	public boolean isSolid(int i){
		return true;
	}
	
	public boolean isDoor(){
		return true;
	}
	
}
