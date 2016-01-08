package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EventPoster1 extends Event {


	static BufferedImage img = Assets.White;
	public EventPoster1(float x, float y, int idnum) {
		super(img,idnum,x, y,0);
	}
	
	public void run(){
//	graphs and tables poster
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
