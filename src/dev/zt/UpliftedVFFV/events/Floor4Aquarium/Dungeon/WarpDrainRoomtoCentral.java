package dev.zt.UpliftedVFFV.events.Floor4Aquarium.Dungeon;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpDrainRoomtoCentral extends Event {
	
	public static int stagenum = 0;
	public WarpDrainRoomtoCentral(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[423].setOpen(false);
		super.getGamestate().getEvents()[423].setFrames(6);
		
		switch(super.getVar(22)){
		case 0:
			super.transport("/Worlds/Floor4Aquarium/WetworksDungeon/CentralChamberNotCleared.txt", 6, 7,"");
			break;
		case 1:
			super.transport("/Worlds/Floor4Aquarium/WetworksDungeon/CentralChamberPartiallyCleared.txt", 6, 7,"");
			break;
		case 2:
			super.transport("/Worlds/Floor4Aquarium/WetworksDungeon/CentralChamberFullyCleared.txt", 6, 7,"");
			break;
			
		}
	}
}
