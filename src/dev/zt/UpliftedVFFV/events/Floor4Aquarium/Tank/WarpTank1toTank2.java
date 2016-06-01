package dev.zt.UpliftedVFFV.events.Floor4Aquarium.Tank;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpTank1toTank2 extends Event {
	
	public static int stagenum = 0;
	public WarpTank1toTank2(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.transport("/Worlds/Floor4Aquarium/AquariumTank/TankCentral.txt", 81, 26,"");
	}
}
