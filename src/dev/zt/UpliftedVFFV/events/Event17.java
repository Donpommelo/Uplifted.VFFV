package dev.zt.UpliftedVFFV.events;

import dev.zt.UpliftedVFFV.gfx.Assets;



public class Event17 extends Event {


	public Event17(float x, float y, int idnum) {
		super(Assets.Stairs,idnum,x, y);
		
	
	}
	

	
	public void run(){
		super.transport("res/Worlds/SouthAquaHall.txt", 11, 24,"4th Floor Tunnel");
	}

	public static void main(String[] args) {
		
	}

}
