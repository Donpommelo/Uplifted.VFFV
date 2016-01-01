package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.consummables.FireExtinguisher;

public class EventSafe2 extends Event {


	static BufferedImage img = Assets.SafeClosed;
	public static int stagenum = 0;
	public EventSafe2(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){
		if(!this.isSelfswitch1()){
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"Found a couple of Fire Extinguishers inside!/Surely that violates some sort of safety regulation. . ./");
			super.Dialog(d, 0, this.getId(), true);
			super.loot(new FireExtinguisher(), 2);
			Event.events[this.getId()].setTex(Assets.SafeOpened);
			this.setSelfswitch1(true);
		}
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
