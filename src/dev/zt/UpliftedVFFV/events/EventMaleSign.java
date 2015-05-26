package dev.zt.UpliftedVFFV.events;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.states.GameState;


public class EventMaleSign extends Event {


	public EventMaleSign(float x, float y, int idnum) {
		super(Assets.MaleSign,idnum,x, y);
		
	
	}
	
	public boolean isSolid(){
		return true;
	}
}
