package dev.zt.UpliftedVFFV.events.Floor4Aquarium.Tank;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpTanktoWElevator extends Event {
	
	public static int stagenum = 0;
	public WarpTanktoWElevator(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		game.getAudiomanager().playMusic(1, true);
		super.getGamestate().getEvents()[305].setOpen(false);
		super.getGamestate().getEvents()[305].setFrames(6);
		super.transport("/Worlds/ElevatorsandBackroom/WestElevator.txt", 5, 7,"West Elevator");
	}
}
