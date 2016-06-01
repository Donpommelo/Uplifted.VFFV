package dev.zt.UpliftedVFFV.events.EventsCommon;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventTallPlant extends Event {


	public EventTallPlant(float x, float y, int idnum) {
		super(Assets.notPenPal,idnum,x, y);
		
	
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
