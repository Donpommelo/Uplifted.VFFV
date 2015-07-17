package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;


import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class Event21 extends Event {


	public Event21(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
	}
	
	public void run(){
		if(Event.events[66].isSelfswitch1()){
			super.transport("/Worlds/Floor3Offices/SouthWingOffices/Lobby.txt", 13, 4,"");
		}
		else{
			super.Dialog(108, 108,this.getId());
		}	
	}
	
	public boolean isSolid(){
		return !Event.events[66].isSelfswitch1();
	}

}
