package dev.zt.UpliftedVFFV.events.Floor3Offices.WestWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventSperosInvisible extends Event {

	public static int stagenum = 3;	
	public static BufferedImage img = Assets.White;
	public EventSperosInvisible(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){
		super.getGamestate().getEvents()[300].run();
	}
	
	public boolean isSolid(int i){
		return true;
	}

}
