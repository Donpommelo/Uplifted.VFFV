package dev.zt.UpliftedVFFV.events;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.states.GameState;


public class EventTable3 extends Event {


	public EventTable3(float x, float y, int idnum) {
		super(Assets.Table3,idnum,x, y);
		
	
	}
	
	public boolean isSolid(){
		return true;
	}
}
