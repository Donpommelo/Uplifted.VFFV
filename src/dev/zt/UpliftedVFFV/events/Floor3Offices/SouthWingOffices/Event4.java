package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.states.GameState;


public class Event4 extends Event {


	public Event4(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
		
	
	}
	

	
	public void run(){
		game.getAudiomanager().playMusic(1, true);
		super.transport("/Worlds/ElevatorsandBackroom/SouthElevator.txt", 3, 4,"South Elevator");
	}

	public static void main(String[] args) {
		
	}

}
