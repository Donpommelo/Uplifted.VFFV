package dev.zt.UpliftedVFFV.events;

import java.awt.image.BufferedImage;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.states.GameState;


public class Event32 extends Event {


	public Event32(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
		
	
	}
	

	
	public void run(){
		super.transport("res/Worlds/ExtraStorageRoom.txt", 10, 7,"");
	}

	public static void main(String[] args) {
		
	}

}
