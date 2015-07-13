package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EventReceptionistDesk extends Event {

	public boolean selfswitch1=false;
	public EventReceptionistDesk(float x, float y, int idnum) {
		super(Assets.Table8,idnum,x, y);
		
	
	}
	

	
	public void run(){
		if(selfswitch1==false){
			super.Dialog(32, 36,this.getId());
			selfswitch1=true;
		}
		else{
			super.Dialog(37, 37,this.getId());
		}
	}
	
	public boolean isSolid(){
		return true;
	}
}
