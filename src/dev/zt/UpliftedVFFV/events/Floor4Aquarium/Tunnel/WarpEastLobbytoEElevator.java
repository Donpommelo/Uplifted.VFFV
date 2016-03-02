package dev.zt.UpliftedVFFV.events.Floor4Aquarium.Tunnel;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpEastLobbytoEElevator extends Event {
	
	public static int stagenum = 0;
	public WarpEastLobbytoEElevator(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		game.getAudiomanager().playMusic(1, true);
		super.getGamestate().getEvents()[215].setOpen(false);
		super.getGamestate().getEvents()[215].setFrames(6);
		super.transport("/Worlds/ElevatorsandBackroom/EastElevator.txt", 5, 7,"East Elevator");
	}
}
