package dev.zt.UpliftedVFFV.events.EventsCommon;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EventEmployeePlant extends Event {

	public boolean selfswitch1=false;
	public static BufferedImage img=SpriteSorter.SpriteSort(10,Assets.PenPal);
	public EventEmployeePlant(float x, float y, int idnum) {
		super(img,idnum,x, y);
		
	
	}
	

	
	public void run(){
		super.Dialog(235, 238,this.getId());

	
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
