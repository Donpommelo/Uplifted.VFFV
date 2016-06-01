package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpCarlocsHalltoCentral extends Event {
	
	public static int stagenum = 0;
	public WarpCarlocsHalltoCentral(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
		
	public void run(){
		if(super.getQuest(5) >= 4){
			super.transport("/Worlds/Floor3Offices/EastWingOffices/EastOfficesCenter.txt",10,21,"East Cubicle");
			if(!this.isSelfswitch1()){
				this.setSelfswitch1(true);
				Dialog[] d = new Dialog[11];
				d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You unlock the door when you pass through it./");
				super.Dialog(d,0, this.getId(), true);
			}
		}
		else{
			Dialog[] d = new Dialog[11];
			d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"The door appears to be locked.");
			super.Dialog(d,0, this.getId(), true);
		}
		
	}
}
