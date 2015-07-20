package dev.zt.UpliftedVFFV.events.EventsCommon;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventTable5 extends Event {


	public EventTable5(float x, float y, int idnum) {
		super(Assets.Table5,idnum,x, y);
		
	
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
