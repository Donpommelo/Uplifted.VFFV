package dev.zt.UpliftedVFFV.events;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.states.GameState;


public class EventTable0 extends Event {


	public EventTable0(float x, float y, int idnum) {
		super(Assets.Table0,idnum,x, y);
		
	
	}
	
	public boolean isSolid(){
		return true;
	}
}
