package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpLobbytoSouthOffice1 extends Event {
	
	public static int stagenum = 0;
	public WarpLobbytoSouthOffice1(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
		
	public void run(){
		super.transport("/Worlds/Floor3Offices/SouthWingOffices/SouthWingSection1.txt", 24, 8,"South Wing Offices");
	}
}
