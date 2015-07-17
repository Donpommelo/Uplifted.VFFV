package dev.zt.UpliftedVFFV.events.ElevatorsandBackroom;


import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class Event2 extends Event {


	public Event2(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
		
	}
	
	public void run(){
		super.transport("/Worlds/ElevatorsandBackroom/backroom.txt", 3, 3,"Home Sweet Home");
		super.setVar(2, 0);
	}
}
