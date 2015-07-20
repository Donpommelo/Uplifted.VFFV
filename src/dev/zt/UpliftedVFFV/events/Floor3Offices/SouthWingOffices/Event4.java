package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;


import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class Event4 extends Event {

	public Event4(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
	}

	public void run(){
		game.getAudiomanager().playMusic(1, true);
		super.transport("/Worlds/ElevatorsandBackroom/SouthElevator.txt", 3, 4,"South Elevator");
	}
}
