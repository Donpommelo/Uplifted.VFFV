package dev.zt.UpliftedVFFV.events.Floor3Offices.WestWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpCubicleDungeonEastEx extends Event {
	
	public static int stagenum = 0;
	public WarpCubicleDungeonEastEx(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
		
	public void run(){
		if(super.getVar(16) >= 9){
			super.transport("/Worlds/Floor3Offices/WestWingOffices/WestCubicleFinalFinal.txt",4,16,"");
		}
		else{
			super.transport("/Worlds/Floor3Offices/WestWingOffices/WestCubicleExtended.txt",4,18,"");
			if(super.getVar(18) == 1 || (super.getVar(18) == 4 && super.getVar(17) == 1) ||
					(super.getVar(18) == 5 && super.getVar(17) == 2) || (super.getVar(18) == 6 && super.getVar(17) == 0)
					|| (super.getVar(18) == 7 && super.getVar(17) == 3)){
				super.setVar(16, super.getVar(16)+1);
			}
			else{
				super.setVar(16, 1);
			}
			super.setVar(17, 1);
			super.setVar(18, (int)(Math.random()*8));
		}
	}
}
