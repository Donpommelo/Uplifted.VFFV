package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class Event70 extends Event {


	public Event70(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
		
	
	}
	

	
	public void run(){
		super.transport("/Worlds/Floor3Offices/EastWingOffices/EastOfficesCenter.txt", 33,41,"");
	}

	public static void main(String[] args) {
		
	}
	
	public boolean isSolid(){
		return false;
	}

}
