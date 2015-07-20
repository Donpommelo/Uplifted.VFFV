package dev.zt.UpliftedVFFV.events.EventsCommon;


import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventTable1 extends Event {


	public EventTable1(float x, float y, int idnum) {
		super(Assets.Table1,idnum,x, y);
		
	
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
