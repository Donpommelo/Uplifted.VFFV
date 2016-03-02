package dev.zt.UpliftedVFFV.events.Floor4Aquarium.Building;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpDisplayRoomtoRightExhibitHall extends Event {
	
	public static int stagenum = 0;
	public WarpDisplayRoomtoRightExhibitHall(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.transport("/Worlds/Floor4Aquarium/AquariumBuilding/SouthRightExhibitRoom.txt", (int)(gamestate.getPlayer().getPlayerX()/32), 4,"");
	}
}
