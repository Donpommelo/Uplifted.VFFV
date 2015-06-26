package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class Event42 extends Event {


	public Event42(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
		
	
	}
	

	
	public void run(){
		super.transport("/Worlds/Floor3Offices/EastWingOffices/EastWingFacade.txt", 2, 8,"East Wing Office");
	}

	public static void main(String[] args) {
		
	}
	
	public boolean isSolid(){
		return false;
	}

}