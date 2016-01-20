package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventInvis2Loop extends Event {

	public static int stagenum = 0;	
	public static BufferedImage img = Assets.Monolith;
	public EventInvis2Loop(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){

	}
	
	public boolean loaded(){
		if(super.getQuest(5) == 2){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean isSolid(int i){
		return true;
	}

}
