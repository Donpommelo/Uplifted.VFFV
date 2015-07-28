package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class Event111 extends Event {


	public Event111(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
	}

	public void run(){
		super.transport("/Worlds/Floor3Offices/EastWingOffices/EastOfficesRightAtriaFloor2.txt", 25,(int)(gamestate.getPlayer().getPlayerY()/32)+7,"");
	}
}
