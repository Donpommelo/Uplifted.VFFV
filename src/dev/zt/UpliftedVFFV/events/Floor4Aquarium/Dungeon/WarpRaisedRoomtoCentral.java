package dev.zt.UpliftedVFFV.events.Floor4Aquarium.Dungeon;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpRaisedRoomtoCentral extends Event {
	
	public static int stagenum = 0;
	public WarpRaisedRoomtoCentral(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[424].setOpen(false);
		super.getGamestate().getEvents()[424].setFrames(6);
		switch(super.getVar(22)){
		case 0:
			super.transport("/Worlds/Floor4Aquarium/WetworksDungeon/CentralChamberNotCleared.txt", 25, 7,"");
			break;
		case 1:
			super.transport("/Worlds/Floor4Aquarium/WetworksDungeon/CentralChamberPartiallyCleared.txt", 25, 7,"");
			break;
		case 2:
			super.transport("/Worlds/Floor4Aquarium/WetworksDungeon/CentralChamberFullyCleared.txt", 25, 7,"");
			break;
			
		}
	}
}
