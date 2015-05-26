package dev.zt.UpliftedVFFV.events;

import dev.zt.UpliftedVFFV.gfx.Assets;



public class Event39 extends Event {


	public Event39(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
		
	
	}
	

	
	public void run(){
		super.transport("/Worlds/SouthOfficeHallway.txt", 36, 1,"South Office Hall");
	}

	public static void main(String[] args) {
		
	}

}
