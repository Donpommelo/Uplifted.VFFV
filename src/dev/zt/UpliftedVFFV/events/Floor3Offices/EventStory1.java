package dev.zt.UpliftedVFFV.events.Floor3Offices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventStory1 extends Event {

	boolean selfswitch1 = false;
	public EventStory1(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
	}
	
	public void run(){
		super.Dialog(251, 252, this.getId());
		selfswitch1 = true;
		super.transport("/Worlds/Floor3Offices/SouthWingOffices/Lobby.txt", 9, 13,"");
	}
		
	public boolean drawn(){
		return !selfswitch1;
	}

}
