package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpWarehousetoGiftshop extends Event {
	
	public static int stagenum = 0;
	public WarpWarehousetoGiftshop(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
		
	public void run(){
		super.transport("/Worlds/Floor4Aquarium/AquariumBuilding/GiftShop2.txt",20,17,"");
	}
}