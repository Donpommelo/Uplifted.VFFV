package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.equipables.SlackerSlacks;

public class EventSafe4 extends Event {


	static BufferedImage img = Assets.SafeClosed;
	public static int stagenum = 0;
	public EventSafe4(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){
		if(!this.isSelfswitch1()){
			Dialog[] d = new Dialog[3];
			d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You open the safe. . ./");
			d[1] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"New pants! Score!/");
			d[2] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You obtained the Slacker Slacks./");
			super.Dialog(d, 2, this.getId(), true);
			super.loot(new SlackerSlacks(), 1);
			Event.events[this.getId()].setTex(Assets.SafeOpened);
			this.setSelfswitch1(true);
		}
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
