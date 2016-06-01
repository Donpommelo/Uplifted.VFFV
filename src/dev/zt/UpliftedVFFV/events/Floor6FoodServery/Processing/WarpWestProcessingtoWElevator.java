package dev.zt.UpliftedVFFV.events.Floor6FoodServery.Processing;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpWestProcessingtoWElevator extends Event {
	
	public static int stagenum = 0;
	public WarpWestProcessingtoWElevator(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
		
	public void run(){
		game.getAudiomanager().playMusic(1, true);
		super.getGamestate().getEvents()[305].setOpen(false);
		super.getGamestate().getEvents()[305].setFrames(6);
		super.transport("/Worlds/ElevatorsandBackroom/WestElevator.txt", 5, 7,"West Elevator");

	}
}
