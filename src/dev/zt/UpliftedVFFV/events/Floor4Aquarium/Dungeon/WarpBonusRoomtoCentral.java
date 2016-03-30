package dev.zt.UpliftedVFFV.events.Floor4Aquarium.Dungeon;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpBonusRoomtoCentral extends Event {
	
	public static int stagenum = 0;
	public WarpBonusRoomtoCentral(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[425].setOpen(false);
		super.getGamestate().getEvents()[425].setFrames(6);
		
		switch(super.getVar(22)){
		case 0:
			super.transport("/Worlds/Floor4Aquarium/WetworksDungeon/CentralChamberPartiallyCleared.txt", 12, 16,"");
			break;
		case 1:
			super.transport("/Worlds/Floor4Aquarium/WetworksDungeon/CentralChamberPartiallyCleared.txt", 12, 16,"");
			break;
		case 2:
			super.transport("/Worlds/Floor4Aquarium/WetworksDungeon/CentralChamberFullyCleared.txt", 12, 16,"");
			break;
			
		}
	}
}
