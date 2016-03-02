package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpWarehousetoGiftshop extends Event {
	
	public static int stagenum = 0;
	public WarpWarehousetoGiftshop(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
		
	public void run(){
		if(!Event.events[406].isSelfswitch1()){
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"This door is locked from the other side./");
			super.Dialog(d, 0, this.getId(), true);
		}
		else{
			super.transport("/Worlds/Floor4Aquarium/AquariumBuilding/GiftShop2.txt",20,17,"Aquarium Giftshop");
		}
	}
}
