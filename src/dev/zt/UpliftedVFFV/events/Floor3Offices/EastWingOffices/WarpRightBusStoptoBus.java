package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpRightBusStoptoBus extends Event {
	
	public static int stagenum = 0;
	public WarpRightBusStoptoBus(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
		
	public void run(){
		super.transport("/Worlds/Floor3Offices/EastWingOffices/EastWingMainHall.txt",14,6,"");
		super.getGamestate().getEvents()[149].setOpen(false);
		super.getGamestate().getEvents()[149].setFrames(6);
		if(!this.isSelfswitch1()){
			this.setSelfswitch1(true);
			Dialog[] d = new Dialog[11];
			d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You unlock the door when you pass through it./");
			super.Dialog(d,0, this.getId(), true);
		}
	}
}
