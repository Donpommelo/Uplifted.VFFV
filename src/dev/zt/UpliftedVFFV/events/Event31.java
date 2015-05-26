package dev.zt.UpliftedVFFV.events;

import java.awt.image.BufferedImage;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.states.GameState;


public class Event31 extends Event {


	public Event31(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
		
	
	}
	

	
	public void run(){
		super.transport("/Worlds/SouthOfficeHallway.txt", 26, 1,"");
	}

	public static void main(String[] args) {
		
	}

}
