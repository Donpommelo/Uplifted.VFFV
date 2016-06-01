package dev.zt.UpliftedVFFV.events.EventsCommon;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventCuidado extends Event {


	public EventCuidado(float x, float y, int idnum) {
		super(Assets.Cuidado,idnum,x, y);
		
	
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
