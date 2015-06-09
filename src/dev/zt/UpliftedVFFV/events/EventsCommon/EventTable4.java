package dev.zt.UpliftedVFFV.events.EventsCommon;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.states.GameState;


public class EventTable4 extends Event {


	public EventTable4(float x, float y, int idnum) {
		super(Assets.Table4,idnum,x, y);
		
	
	}
	
	public boolean isSolid(){
		return true;
	}
}
