package dev.zt.UpliftedVFFV.events.EventsCommon;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class EventTable3 extends Event {


	public EventTable3(float x, float y, int idnum) {
		super(Assets.Table3,idnum,x, y);
		
	
	}
	
	public boolean isSolid(){
		return true;
	}
}
