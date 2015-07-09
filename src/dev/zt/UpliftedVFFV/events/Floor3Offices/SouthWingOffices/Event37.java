package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;


import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class Event37 extends Event {


	public Event37(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
		
	
	}
	

	
	public void run(){
//		if(Event.events[66].isSelfswitch1()){
			super.Dialog(144, 144,this.getId());
//		}
	}


	public boolean isSolid(){
		return true;
	}

}
