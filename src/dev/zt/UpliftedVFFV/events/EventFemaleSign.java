package dev.zt.UpliftedVFFV.events;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.states.GameState;


public class EventFemaleSign extends Event {


	public EventFemaleSign(float x, float y, int idnum) {
		super(Assets.FemaleSign,idnum,x, y);
		
	
	}
	
	public boolean isSolid(){
		return true;
	}
}
