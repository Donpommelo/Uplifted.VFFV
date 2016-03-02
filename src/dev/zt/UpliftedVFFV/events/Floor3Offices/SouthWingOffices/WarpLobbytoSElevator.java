package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;


import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class WarpLobbytoSElevator extends Event {
	
	public static int stagenum = 0;
	public WarpLobbytoSElevator(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		game.getAudiomanager().playMusic(1, true);
		super.getGamestate().getEvents()[3].setOpen(false);
		super.getGamestate().getEvents()[3].setFrames(6);
		super.transport("/Worlds/ElevatorsandBackroom/SouthElevator.txt", 5, 7,"South Elevator");
	}
}
