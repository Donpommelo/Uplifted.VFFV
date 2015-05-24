package dev.zt.UpliftedVFFV.events;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.states.GameState;


public class EventTable6 extends Event {


	public EventTable6(float x, float y, int idnum) {
		super(Assets.Table6,idnum,x, y);
		
	
	}
	
	public boolean isSolid(){
		return true;
	}
}
