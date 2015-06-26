package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.states.GameState;


public class Event20 extends Event {


	public Event20(float x, float y, int idnum) {
		super(Assets.StairsDown,idnum,x, y);
		
	
	}
	

	
	public void run(){
		super.transport("/Worlds/Floor3Offices/SouthWingOffices/SouthAquaHall.txt", 11, 12,"");
	}

	public static void main(String[] args) {
		
	}

}