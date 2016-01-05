package dev.zt.UpliftedVFFV.events.EventsCommon;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventWorkDesk2 extends Event {


	public EventWorkDesk2(float x, float y, int idnum) {
		super(Assets.WorkDesk2,idnum,x, y);
		
	
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
