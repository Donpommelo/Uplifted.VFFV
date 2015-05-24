package dev.zt.UpliftedVFFV.events;

import dev.zt.UpliftedVFFV.gfx.Assets;



public class Event18 extends Event {


	public Event18(float x, float y, int idnum) {
		super(Assets.Stairs,idnum,x, y);
		
	
	}
	

	
	public void run(){
		super.transport("res/Worlds/SouthHallSmall.txt", 3, 2,"3rd Floor Hallway");
	}

	public static void main(String[] args) {
		
	}

}
