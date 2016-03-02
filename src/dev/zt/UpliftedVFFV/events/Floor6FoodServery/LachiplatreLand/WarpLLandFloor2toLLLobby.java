package dev.zt.UpliftedVFFV.events.Floor6FoodServery.LachiplatreLand;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpLLandFloor2toLLLobby extends Event {
	
	public static int stagenum = 0;
	public WarpLLandFloor2toLLLobby(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		if(!Event.events[457].isSelfswitch1()){
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"This door is locked./");
			super.Dialog(d, 0, this.getId(), true);
		}
		else{
			super.getGamestate().getEvents()[459].setOpen(false);
			super.getGamestate().getEvents()[459].setFrames(6);
			super.transport("/Worlds/Floor6FoodServery/LachiplatreLand/LachiplatreLobby.txt",9,7,"");
		}
	}
}
