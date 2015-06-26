package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.MedPak;
import dev.zt.UpliftedVFFV.states.GameState;


public class EventSafe1 extends Event {


	static BufferedImage img = Assets.SafeClosed;
	boolean selfswitch1 = false;
	public EventSafe1(float x, float y, int idnum) {
		super(img,idnum,x, y);
	}
	
	public void run(){
		if(!selfswitch1){
			super.Dialog(179, 179,this.getId());
			super.loot(new MedPak(), 3);
			Event.events[this.getId()].setTex(Assets.SafeOpened);
			selfswitch1 = true;
		}
	}
	
	public boolean isSolid(){
		return true;
	}
}