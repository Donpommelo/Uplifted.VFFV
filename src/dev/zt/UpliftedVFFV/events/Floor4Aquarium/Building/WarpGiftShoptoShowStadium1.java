package dev.zt.UpliftedVFFV.events.Floor4Aquarium.Building;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpGiftShoptoShowStadium1 extends Event {
	
	public static int stagenum = 0;
	public WarpGiftShoptoShowStadium1(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[395].setOpen(false);
		super.getGamestate().getEvents()[395].setFrames(6);
		super.transport("/Worlds/Floor4Aquarium/AquariumBuilding/ShowStadium1.txt",8,15,"");
		
	}
}
