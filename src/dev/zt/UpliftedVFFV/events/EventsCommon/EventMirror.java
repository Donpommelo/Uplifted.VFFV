package dev.zt.UpliftedVFFV.events.EventsCommon;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventMirror extends Event {


	public EventMirror(float x, float y, int idnum) {
		super(Assets.Mirror,idnum,x, y);
		
	
	}
	
	public boolean isSolid(){
		return true;
	}
}
