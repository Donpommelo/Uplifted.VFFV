package dev.zt.UpliftedVFFV.events.EventsCommon;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventSofaUp extends Event {


	public EventSofaUp(float x, float y, int idnum) {
		super(Assets.Sofa1,idnum,x, y);
		
	
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
