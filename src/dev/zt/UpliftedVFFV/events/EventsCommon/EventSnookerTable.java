package dev.zt.UpliftedVFFV.events.EventsCommon;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventSnookerTable extends Event {


	public EventSnookerTable(float x, float y, int idnum) {
		super(Assets.SnookerTable,idnum,x, y);
		
	
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
