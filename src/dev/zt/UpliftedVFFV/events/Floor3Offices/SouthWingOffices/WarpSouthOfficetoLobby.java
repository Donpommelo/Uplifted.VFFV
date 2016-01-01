package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class WarpSouthOfficetoLobby extends Event {


	public WarpSouthOfficetoLobby(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
	}
		
	public void run(){
		if(!super.getSwitch(2)){
			super.transport("/Worlds/Floor3Offices/SouthWingOffices/Lobby.txt", 3, 8,"South Lobby");

		}
		else{
			super.transport("/Worlds/Floor3Offices/SouthWingOffices/PostJorgeLobby.txt", 3, 8,"South Lobby");
		}
	}
}
