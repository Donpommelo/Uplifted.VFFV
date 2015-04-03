package dev.zt.UpliftedVFFV.events;

import java.awt.image.BufferedImage;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.states.GameState;


public class Event1 extends Event {


	public Event1(float x, float y, int idnum) {
		super(Assets.Black,idnum,x, y);
		
	
	}
	

	
	public void run(){
		super.transport("res/Worlds/SouthElevator.txt", 3, 6,"South Elevator");
	}

	public static void main(String[] args) {
		if(game==null){System.out.print("meep");}
	}

}
