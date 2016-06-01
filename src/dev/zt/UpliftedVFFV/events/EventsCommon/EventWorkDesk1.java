package dev.zt.UpliftedVFFV.events.EventsCommon;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventWorkDesk1 extends Event {


	public EventWorkDesk1(float x, float y, int idnum) {
		super(Assets.WorkDesk1,idnum,x, y);
		
	
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
