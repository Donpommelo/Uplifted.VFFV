package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpActualEasttoNowhere extends Event {
	
	public static int stagenum = 0;
	public WarpActualEasttoNowhere(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
		
	public void run(){
		Dialog[] d = new Dialog[1];
		d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"This door is locked./");
		super.Dialog(d, 0, this.getId(), true);

		
	}
	
	public boolean isSolid(){
		return true;
	}
	
	public boolean isDoor(){
		return true;
	}
}
