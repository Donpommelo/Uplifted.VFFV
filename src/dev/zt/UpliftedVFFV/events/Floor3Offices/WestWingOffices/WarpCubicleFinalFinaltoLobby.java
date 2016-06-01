package dev.zt.UpliftedVFFV.events.Floor3Offices.WestWingOffices;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpCubicleFinalFinaltoLobby extends Event {
	
	public static int stagenum = 1;
	public WarpCubicleFinalFinaltoLobby(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
		
	public void run(){
		switch(this.getstage()){
		case 0:
			super.fite(28, this.getId(), false,true);
			break;
		case 1:
			if(isFightwon()){
				super.transport("/Worlds/Floor3Offices/WestWingOffices/Lobby.txt",9,11,"West Lobby");
				super.setVar(16, 0);
				super.setSwitch(27, true);
				super.Timer(this.getId(), 10);
			}
			else{
				this.setstage(0);
			}
			break;
		case 2:
			this.setstage(0);
			super.screenShake(25);
			break;
		}
		
	}
}
