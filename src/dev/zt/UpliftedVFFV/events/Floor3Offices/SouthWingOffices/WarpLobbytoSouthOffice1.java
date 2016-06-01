package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpLobbytoSouthOffice1 extends Event {
	
	public static int stagenum = 1;
	public WarpLobbytoSouthOffice1(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
		
	public void run(){
		super.transport("/Worlds/Floor3Offices/SouthWingOffices/SouthWingSection1.txt", 24, 8,"South Offices");
		if(!this.isSelfswitch1()){
			switch(this.getstage()){
			case 0:
				Dialog[] d = new Dialog[1];
				d[0] = new Dialog("Pen Pal" ,"/CharacterBusts/Player-5.png" ,1 ,"Operator! Careful!");
				super.Dialog(d, 0, this.getId(), true);
				break;
			case 1:
				this.setSelfswitch1(true);
				super.fite(0, this.getId(), false, true);
				break;
			
			}
		}
	}
}
