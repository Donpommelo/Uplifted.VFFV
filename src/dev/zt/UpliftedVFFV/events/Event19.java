package dev.zt.UpliftedVFFV.events;

import java.awt.image.BufferedImage;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.states.GameState;


public class Event19 extends Event {


	public Event19(float x, float y, int idnum) {
		super(Assets.StairsDown,idnum,x, y);
		
	
	}
	

	
	public void run(){
		super.transport("/Worlds/SouthOfficeHallway.txt", 4, 12,"3rd Floor Hallway");
	}

	public static void main(String[] args) {
		
	}

}
