package dev.zt.UpliftedVFFV.events;

import java.awt.image.BufferedImage;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.states.GameState;


public class Event27 extends Event {


	public Event27(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
		
	
	}
	

	
	public void run(){
		super.transport("/Worlds/SouthHallSmall.txt", 5, 8,"");
	}

	public static void main(String[] args) {
		
	}

}
