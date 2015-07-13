package dev.zt.UpliftedVFFV.events.EventsCommon;


import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventTable7 extends Event {


	public EventTable7(float x, float y, int idnum) {
		super(Assets.Table7,idnum,x, y);
		
	
	}
	
	public boolean isSolid(){
		return true;
	}
}
