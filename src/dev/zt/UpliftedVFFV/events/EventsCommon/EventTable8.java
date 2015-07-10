package dev.zt.UpliftedVFFV.events.EventsCommon;


import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventTable8 extends Event {


	public EventTable8(float x, float y, int idnum) {
		super(Assets.Table8,idnum,x, y);
		
	
	}
	
	public boolean isSolid(){
		return true;
	}
}
