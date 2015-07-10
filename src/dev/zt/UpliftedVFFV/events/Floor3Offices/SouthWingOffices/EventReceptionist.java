package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EventReceptionist extends Event {

	public boolean selfswitch1=false;
	public static BufferedImage img=SpriteSorter.SpriteSort(1,Assets.EmployeeF);
	public EventReceptionist(float x, float y, int idnum) {
		super(img,idnum,x, y);
		
	
	}
	

	
	public void run(){
		
	}
	
	public boolean isSolid(){
		return true;
	}
}
