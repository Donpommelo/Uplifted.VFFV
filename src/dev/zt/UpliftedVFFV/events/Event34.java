package dev.zt.UpliftedVFFV.events;

import java.awt.image.BufferedImage;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.states.GameState;


public class Event34 extends Event {


	public Event34(float x, float y, int idnum) {
		super(Assets.Black,idnum,x, y);
		
	
	}
	

	
	public void run(){
		super.transport("res/Worlds/SouthOfficeHallway.txt", 1, 4,"");
	}

	public static void main(String[] args) {
		
	}

}
