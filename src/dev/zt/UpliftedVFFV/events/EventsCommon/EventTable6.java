package dev.zt.UpliftedVFFV.events.EventsCommon;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventTable6 extends Event {


	public EventTable6(float x, float y, int idnum) {
		super(Assets.Table6,idnum,x, y);
		
	
	}
	
	public boolean isSolid(){
		return true;
	}
}
