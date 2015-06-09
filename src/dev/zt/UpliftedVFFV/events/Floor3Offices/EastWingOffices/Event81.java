package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class Event81 extends Event {


	public Event81(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
		
	
	}
	

	
	public void run(){
		super.transport("/Worlds/Floor3Offices/EastWingOffices/EastOfficesLeftMain2Room1.txt", 9,7,"");
	}

	public static void main(String[] args) {
		
	}
	
	public boolean isSolid(){
		return false;
	}

}
