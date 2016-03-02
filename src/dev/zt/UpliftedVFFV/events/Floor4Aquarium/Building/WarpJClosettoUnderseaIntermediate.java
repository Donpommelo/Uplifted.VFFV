package dev.zt.UpliftedVFFV.events.Floor4Aquarium.Building;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpJClosettoUnderseaIntermediate extends Event {
	
	public static int stagenum = 0;
	public WarpJClosettoUnderseaIntermediate(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[380].setOpen(false);
		super.getGamestate().getEvents()[380].setFrames(6);
		super.transport("/Worlds/Floor4Aquarium/AquariumBuilding/UnderwaterIntermediate.txt",6,7,"");
		
	}
}
