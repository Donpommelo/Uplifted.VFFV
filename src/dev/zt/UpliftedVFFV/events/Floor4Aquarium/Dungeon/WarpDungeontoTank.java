package dev.zt.UpliftedVFFV.events.Floor4Aquarium.Dungeon;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpDungeontoTank extends Event {
	
	public static int stagenum = 0;
	public WarpDungeontoTank(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.getGamestate().getEvents()[421].setOpen(false);
		super.getGamestate().getEvents()[421].setFrames(6);
		super.transport("/Worlds/Floor4Aquarium/AquariumTank/TankCentral.txt", 12, 75,"");
		super.setSwitch(34, true);
	}
}
