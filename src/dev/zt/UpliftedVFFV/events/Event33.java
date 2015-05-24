package dev.zt.UpliftedVFFV.events;

import java.awt.image.BufferedImage;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.states.GameState;


public class Event33 extends Event {


	public Event33(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
		
	
	}
	

	
	public void run(){
		super.transport("res/Worlds/Mailroom.txt", 1, 7,"Mailroom");
	}

	public static void main(String[] args) {
		
	}

}
