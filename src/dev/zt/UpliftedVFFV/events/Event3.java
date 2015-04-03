package dev.zt.UpliftedVFFV.events;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.states.GameState;


public class Event3 extends Event {

	public static BufferedImage img=Assets.ElevatorDoor1;
	public Event3(float x, float y, int idnum) {
		super(img,idnum,x, y);
		
	
	}
	

	
	public void run(){

		
		super.transport("res/Worlds/Lobby.txt", 7, 10,"South Lobby");
	}

	public static void main(String[] args) {
		
	}

}
