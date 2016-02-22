package dev.zt.UpliftedVFFV.events.Floor2Bathhouse;


import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class WarpSouthBathhousetoElevator extends Event {
	
	public static int stagenum = 0;
	public WarpSouthBathhousetoElevator(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		game.getAudiomanager().playMusic(1, true);
		super.transport("/Worlds/ElevatorsandBackroom/SouthElevator.txt", 5, 7,"South Elevator");
	}
}
