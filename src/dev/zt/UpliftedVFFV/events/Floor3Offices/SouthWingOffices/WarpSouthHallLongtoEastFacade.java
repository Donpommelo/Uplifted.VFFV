package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;


import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class WarpSouthHallLongtoEastFacade extends Event {


	public WarpSouthHallLongtoEastFacade(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);	
	}
	
	public void run(){
		if(!super.getSwitch(2)){
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"Hold on!/Weren't we supposed to be going to the Mailroom to talk to that Jorge fellow?/We should head back North first./");
			super.Dialog(d, 0, this.getId(), true);
		}
		else{
			if(!super.getSwitch(3)){
				Dialog[] d = new Dialog[1];
				d[0] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"We should come this way later. I have something I want to show you first in your home./");
				super.Dialog(d, 0, this.getId(), true);
			}
			else{
				super.transport("/Worlds/Floor3Offices/EastWingOffices/EastWingLobby.txt", 4, 8,"East Offices");
			}		
		}
	}
	
	public boolean isSolid(int i){
		return true;
	}
	
	public boolean isDoor(){
		return true;
	}
}
