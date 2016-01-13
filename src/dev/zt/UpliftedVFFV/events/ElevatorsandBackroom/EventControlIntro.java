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
			Dialog[] d = new Dialog[2];
			d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"Arrow Keys to move./Space to interact, select, and advance dialogue./");
			d[1] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"Z to pull up menu/X to back./");
			super.Dialog(d, 1, this.getId(), true);
			this.setSelfswitch1(true);
		}
		
	}
	

}
