package dev.zt.UpliftedVFFV.events;

import java.awt.image.BufferedImage;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.states.GameState;


public class Event11 extends Event {


	public Event11(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
		
	
	}
	

	
	public void run(){
		super.transport("res/Worlds/SouthHallSmall.txt", 5, 17,"");
	}

	public static void main(String[] args) {
		
	}

}
