package dev.zt.UpliftedVFFV.events.Floor4Aquarium.Tank;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpTank2toTank1 extends Event {
	
	public static int stagenum = 0;
	public WarpTank2toTank1(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		super.transport("/Worlds/Floor4Aquarium/AquariumTank/TankMain.txt", 81, 17,"");
	}
}
