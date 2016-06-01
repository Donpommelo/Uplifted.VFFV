package dev.zt.UpliftedVFFV.events.Floor7Infirmary.Main;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpCircleBalconytoWaitingRoom extends Event {
	
	public static int stagenum = 0;
	public WarpCircleBalconytoWaitingRoom(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[551].setOpen(false);
		super.getGamestate().getEvents()[551].setFrames(6);
		super.transport("/Worlds/Floor7Infirmary/WaitingRoom.txt", 16, 7,"Waiting Room");
	}
}
