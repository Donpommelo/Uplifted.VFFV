package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class Event17 extends Event {


	public Event17(float x, float y, int idnum) {
		super(Assets.Stairs,idnum,x, y);
	}
	
	public void run(){
		super.transport("/Worlds/Floor3Offices/SouthWingOffices/SouthAquaHall.txt",(int)(gamestate.getPlayer().getPlayerX()/32)+8, 24,"4th Floor Tunnel");
	}
}
