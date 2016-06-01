package dev.zt.UpliftedVFFV.events.Floor4Aquarium.Dungeon;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpMazetoRaisedRoomLeft extends Event {
	
	public static int stagenum = 0;
	public WarpMazetoRaisedRoomLeft(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[432].setOpen(false);
		super.getGamestate().getEvents()[432].setFrames(6);
		
		switch(super.getVar(22)){
		case 0:
			super.transport("/Worlds/Floor4Aquarium/WetworksDungeon/RaisedPathRoomNotCleared.txt", 18, 10,"");
			break;
		case 1:
			super.transport("/Worlds/Floor4Aquarium/WetworksDungeon/RaisedPathRoomPartiallyCleared.txt", 18, 10,"");
			break;
		case 2:
			super.transport("/Worlds/Floor4Aquarium/WetworksDungeon/RaisedPathRoomFullyCleared.txt", 18, 10,"");
			break;
			
		}
	}
}