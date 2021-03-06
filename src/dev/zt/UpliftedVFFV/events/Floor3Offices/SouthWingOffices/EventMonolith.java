package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EventMonolith extends Event {


	static BufferedImage img = Assets.Monolith;
	public EventMonolith(float x, float y, int idnum) {
		super(img,idnum,x, y,0);
	}
	
	public void run(){
		super.Examine(Assets.southMonolith, this.getId());
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
