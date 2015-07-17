package dev.zt.UpliftedVFFV.events.EventsCommon;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventMaleSign extends Event {


	public EventMaleSign(float x, float y, int idnum) {
		super(Assets.MaleSign,idnum,x, y);
		
	
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
