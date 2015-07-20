package dev.zt.UpliftedVFFV.events.EventsCommon;



import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventClock extends Event {

	public boolean selfswitch1=false;
	public EventClock(float x, float y, int idnum) {
		super(Assets.Clock,idnum,x, y);
		
	
	}
	

	
	public void run(){
//		super.Dialog(165, 165,this.getId());

	}

	public boolean isSolid(int i){
		return true;
	}
}
