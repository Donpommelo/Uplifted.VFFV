package dev.zt.UpliftedVFFV.events.EventsCommon;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventInvisWall extends Event {


	public EventInvisWall(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
		
	
	}
	
	public boolean isSolid(){
		return true;
	}
}
