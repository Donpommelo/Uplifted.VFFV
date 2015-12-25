package dev.zt.UpliftedVFFV.events.ElevatorsandBackroom;


import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpSElevatortoBackroom extends Event {

	public static int stagenum = 0;
	public WarpSElevatortoBackroom(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y,stagenum);
		
	}
	
	public void run(){
		super.transport("/Worlds/ElevatorsandBackroom/HomeSweetElevator.txt", 10, 6,"Home Sweet Home");
		super.setVar(2, 0);
	}
}
