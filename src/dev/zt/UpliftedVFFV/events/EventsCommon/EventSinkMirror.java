package dev.zt.UpliftedVFFV.events.EventsCommon;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventSinkMirror extends Event {


	public EventSinkMirror(float x, float y, int idnum) {
		super(Assets.SinkMirror,idnum,x, y);
		
	
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
