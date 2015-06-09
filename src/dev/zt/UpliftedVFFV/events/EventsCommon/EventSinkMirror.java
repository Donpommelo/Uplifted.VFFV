package dev.zt.UpliftedVFFV.events.EventsCommon;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.states.GameState;


public class EventSinkMirror extends Event {


	public EventSinkMirror(float x, float y, int idnum) {
		super(Assets.SinkMirror,idnum,x, y);
		
	
	}
	
	public boolean isSolid(){
		return true;
	}
}
