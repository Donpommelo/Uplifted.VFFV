package dev.zt.UpliftedVFFV.events.EventsCommon;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.states.GameState;


public class EventFilingCabinet extends Event {


	public EventFilingCabinet(float x, float y, int idnum) {
		super(Assets.FilingCabinet,idnum,x, y);
		
	
	}
	
	public boolean isSolid(){
		return true;
	}
}
