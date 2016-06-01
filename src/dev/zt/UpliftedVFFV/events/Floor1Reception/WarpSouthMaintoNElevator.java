package dev.zt.UpliftedVFFV.events.Floor1Reception;


import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpSouthMaintoNElevator extends Event {
	
	public static int stagenum = 0;
	public WarpSouthMaintoNElevator(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		game.getAudiomanager().playMusic(1, true);
		super.transport("/Worlds/ElevatorsandBackroom/NorthElevator.txt", 5, 7,"North Elevator?");
	}
}