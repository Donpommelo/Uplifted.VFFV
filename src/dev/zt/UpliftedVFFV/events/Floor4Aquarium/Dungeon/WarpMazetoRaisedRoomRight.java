package dev.zt.UpliftedVFFV.events.Floor4Aquarium.Dungeon;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpMazetoRaisedRoomRight extends Event {
	
	public static int stagenum = 0;
	public WarpMazetoRaisedRoomRight(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){		
		switch(super.getVar(22)){
		case 0:
			super.transport("/Worlds/Floor4Aquarium/WetworksDungeon/RaisedPathRoomNotCleared.txt", 42, 11,"");
			break;
		case 1:
			super.transport("/Worlds/Floor4Aquarium/WetworksDungeon/RaisedPathRoomPartiallyCleared.txt", 42, 11,"");
			break;
		case 2:
			super.transport("/Worlds/Floor4Aquarium/WetworksDungeon/RaisedPathRoomFullyCleared.txt", 42, 11,"");
			break;
			
		}
	}
}
