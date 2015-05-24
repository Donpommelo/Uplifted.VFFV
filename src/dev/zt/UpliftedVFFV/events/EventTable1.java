package dev.zt.UpliftedVFFV.events;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.states.GameState;


public class EventTable1 extends Event {


	public EventTable1(float x, float y, int idnum) {
		super(Assets.Table1,idnum,x, y);
		
	
	}
	
	public boolean isSolid(){
		return true;
	}
}
