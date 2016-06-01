package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class WarpLobbytoSouthOfficeHall extends Event {

	public static int stagenum = 0;
	public WarpLobbytoSouthOfficeHall(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
	
	public void run(){
		super.transport("/Worlds/Floor3Offices/SouthWingOffices/SouthOfficeHallway.txt", 27, 37,"South Offices");
	}
}
