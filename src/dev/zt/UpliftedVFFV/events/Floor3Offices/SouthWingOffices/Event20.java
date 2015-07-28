package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class Event20 extends Event {


	public Event20(float x, float y, int idnum) {
		super(Assets.StairsDown,idnum,x, y);
	}
	
	public void run(){
		super.transport("/Worlds/Floor3Offices/SouthWingOffices/SouthAquaHall.txt", (int)(gamestate.getPlayer().getPlayerX()/32)+7, 12,"");
	}
}
