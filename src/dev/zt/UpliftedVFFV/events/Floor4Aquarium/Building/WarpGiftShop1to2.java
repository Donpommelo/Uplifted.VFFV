package dev.zt.UpliftedVFFV.events.Floor4Aquarium.Building;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpGiftShop1to2 extends Event {
	
	public static int stagenum = 0;
	public WarpGiftShop1to2(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.transport("/Worlds/Floor4Aquarium/AquariumBuilding/GiftShop2.txt", (int)(gamestate.getPlayer().getPlayerX()/32), 30,"");
	}
}
