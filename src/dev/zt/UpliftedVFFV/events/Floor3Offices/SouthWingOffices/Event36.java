package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;


import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class Event36 extends Event {


	public Event36(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);	
	}
	
	public void run(){
/*		if(Event.events[66].isSelfswitch1()){
			super.Dialog(109, 109,this.getId());
		}
		else{
			if(Event.events[139].isSelfswitch1()){*/
				super.transport("/Worlds/Floor3Offices/EastWingOffices/EastWingLobby.txt", 1, 4,"East Wing Lobby");
//			}		
//		}
	}
	
	public boolean isSolid(int i){
		return !Event.events[66].isSelfswitch1();
	}
}
