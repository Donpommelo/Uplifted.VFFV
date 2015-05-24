package dev.zt.UpliftedVFFV.events;

import java.awt.image.BufferedImage;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.states.GameState;


public class Event38 extends Event {


	public Event38(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
		
	
	}
	

	
	public void run(){
		super.transport("res/Worlds/JanitorCloset.txt", 3, 7,"Broom Closet");
	}

	public static void main(String[] args) {
		
	}

}
