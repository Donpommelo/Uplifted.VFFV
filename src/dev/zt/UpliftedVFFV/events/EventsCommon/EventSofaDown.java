package dev.zt.UpliftedVFFV.events.EventsCommon;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventSofaDown extends Event {


	public EventSofaDown(float x, float y, int idnum) {
		super(Assets.Sofa3,idnum,x, y);
		
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
