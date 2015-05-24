package dev.zt.UpliftedVFFV.events;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.states.GameState;


public class EventTable5 extends Event {


	public EventTable5(float x, float y, int idnum) {
		super(Assets.Table5,idnum,x, y);
		
	
	}
	
	public boolean isSolid(){
		return true;
	}
}
