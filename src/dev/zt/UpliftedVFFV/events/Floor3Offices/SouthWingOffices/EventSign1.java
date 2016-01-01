package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EventSign1 extends Event {


	static BufferedImage img = Assets.Sign;
	public static int stagenum = 0;
	public EventSign1(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"West: Conference Room./East: Mailroom./");
			super.Dialog(d, 0, this.getId(), true);		
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
