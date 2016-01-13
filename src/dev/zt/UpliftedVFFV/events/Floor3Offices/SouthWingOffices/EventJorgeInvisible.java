package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventJorgeInvisible extends Event {

	public static int stagenum = 3;	
	public static BufferedImage img = Assets.White;
	public EventJorgeInvisible(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){
		super.getGamestate().getEvents()[100].run();
	}
	
	public boolean isSolid(int i){
		return true;
	}

}
