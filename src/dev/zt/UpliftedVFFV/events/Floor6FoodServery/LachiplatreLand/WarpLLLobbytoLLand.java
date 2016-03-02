package dev.zt.UpliftedVFFV.events.Floor6FoodServery.LachiplatreLand;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpLLLobbytoLLand extends Event {
	
	public static int stagenum = 0;
	public WarpLLLobbytoLLand(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.transport("/Worlds/Floor6FoodServery/LachiplatreLand/LachiplatreLand1.txt",47,29,"");
		if(!this.isSelfswitch1()){
			this.setSelfswitch1(true);
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You unlock the door when you pass through it./");
			super.Dialog(d,0, this.getId(), true);
		}
	}
}
