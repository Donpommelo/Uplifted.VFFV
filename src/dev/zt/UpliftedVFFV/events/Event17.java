package dev.zt.UpliftedVFFV.events;

import java.awt.image.BufferedImage;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.states.GameState;


public class Event17 extends Event {


	public Event17(float x, float y, int idnum) {
		super(Assets.Black,idnum,x, y);
		
	
	}
	

	
	public void run(){
		super.transport("res/Worlds/SouthAquaHall.txt", 3, 14,"");
	}

	public static void main(String[] args) {
		
	}

}