package dev.zt.UpliftedVFFV.events.EventsCommon;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventTable0 extends Event {


	public EventTable0(float x, float y, int idnum) {
		super(Assets.Table0,idnum,x, y);
		
	
	}
	
	public boolean isSolid(){
		return true;
	}
}
