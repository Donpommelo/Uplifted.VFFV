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
			d[0] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"We should come this way later. I have something I want to show you first in your home./");
			super.Dialog(d, 0, this.getId(), true);
		}
		else{
//			if(Event.events[100].isSelfswitch1()){
//				super.transport("/Worlds/Floor3Offices/EastWingOffices/EastWingLobby.txt", 1, 4,"East Wing Lobby");
//			}		
		}
	}
	
	public boolean isSolid(int i){
		return !super.getSwitch(2);
	}
}
