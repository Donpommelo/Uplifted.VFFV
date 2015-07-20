package dev.zt.UpliftedVFFV.events.EventsCommon;


import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventFilingCabinet extends Event {


	public EventFilingCabinet(float x, float y, int idnum) {
		super(Assets.FilingCabinet,idnum,x, y);
		
	
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
