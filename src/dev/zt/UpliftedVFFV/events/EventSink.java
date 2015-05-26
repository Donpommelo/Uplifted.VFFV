package dev.zt.UpliftedVFFV.events;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.states.GameState;


public class EventSink extends Event {


	public EventSink(float x, float y, int idnum) {
		super(Assets.Sink,idnum,x, y);
		
	
	}
	
	public boolean isSolid(){
		return true;
	}
}
