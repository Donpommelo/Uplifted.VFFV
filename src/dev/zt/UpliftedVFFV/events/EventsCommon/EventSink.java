package dev.zt.UpliftedVFFV.events.EventsCommon;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class EventSink extends Event {


	public EventSink(float x, float y, int idnum) {
		super(Assets.Sink,idnum,x, y);
		
	
	}
	
	public boolean isSolid(){
		return true;
	}
}
