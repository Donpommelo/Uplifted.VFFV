package dev.zt.UpliftedVFFV.events.Floor4Aquarium.Tunnel;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpEastTunneltoGiftShop extends Event {
	
	public static int stagenum = 0;
	public WarpEastTunneltoGiftShop(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[405].setOpen(false);
		super.getGamestate().getEvents()[405].setFrames(6);
		super.transport("/Worlds/Floor4Aquarium/AquariumBuilding/GiftShop2.txt",7,6,"");
		if(!this.isSelfswitch1()){
			this.setSelfswitch1(true);
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You unlock the door when you pass through it./");
			super.Dialog(d,0, this.getId(), true);
		}
	}
}
