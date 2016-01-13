package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EventSafe3 extends Event {


	static BufferedImage img = Assets.SafeClosed;
	public static int frame;
	public static boolean blinking;
	public static int stagenum = 0;
	public EventSafe3(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
		frame = 0;
		blinking = false;
	}
	
	public void run(){
		if(!this.isSelfswitch1()){
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You find some Caffeine Patches in the Safe./");
			super.Dialog(d, 0, this.getId(), true);
			super.scriptChange(15);
			Event.getEvents()[this.getId()].setTex(Assets.SafeOpened);
			this.setSelfswitch1(true);
		}
	}
	
	public void tick(){
		if(!this.isSelfswitch1()){
			frame++;
			if(frame>=50){
				frame = 0;
				if(blinking){
					this.setTex(Assets.SafeClosed);
					blinking = false;
				}
				else{
					this.setTex(Assets.SafeClosed2);
					blinking = true;
				}
			}
		}
	}
	
	
	public boolean isSolid(int i){
		return true;
	}
}
