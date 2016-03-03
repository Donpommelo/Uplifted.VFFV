package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpBustoRamp extends Event {
	
	public static int stagenum = 0;
	public WarpBustoRamp(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
		
	public void run(){
		if(super.getQuest(5) <= 3){
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"This door is locked./");
			super.Dialog(d, 0, this.getId(), true);
		}
		else{
			super.transport("/Worlds/Floor3Offices/EastWingOffices/EastWingOutside.txt", 31,39,"Bus Ramp");
			super.getGamestate().getEvents()[203].setOpen(false);
			super.getGamestate().getEvents()[203].setFrames(6);
		}
	}
}
