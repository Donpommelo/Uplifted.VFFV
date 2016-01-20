package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventCarlocOfficeInvisible extends Event {

	public static int stagenum = 3;	
	public static BufferedImage img = Assets.White;
	public EventCarlocOfficeInvisible(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){
		super.getGamestate().getEvents()[209].run();
	}
	
	public boolean isSolid(int i){
		return true;
	}

}
