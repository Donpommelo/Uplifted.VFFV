package dev.zt.UpliftedVFFV.events.ElevatorsandBackroom;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EventControlIntro extends Event {


	static BufferedImage img = Assets.White;
	public EventControlIntro(float x, float y, int idnum) {
		super(img,idnum,x, y,0);
	}
	
	public void run(){
		if(!this.isSelfswitch1()){
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"Arrow Keys : move and navigate menu     Z : open menu/Space : interact, select, and advance dialogue./X : back");
			super.Dialog(d, 0, this.getId(), true);
			this.setSelfswitch1(true);
		}
		
	}
	

}
