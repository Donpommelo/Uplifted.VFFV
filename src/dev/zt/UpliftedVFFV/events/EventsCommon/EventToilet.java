package dev.zt.UpliftedVFFV.events.EventsCommon;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.states.GameState;


public class EventToilet extends Event {


	public EventToilet(float x, float y, int idnum) {
		super(Assets.Toilet,idnum,x, y);
		
	
	}
	
	public boolean isSolid(){
		return true;
	}
}
