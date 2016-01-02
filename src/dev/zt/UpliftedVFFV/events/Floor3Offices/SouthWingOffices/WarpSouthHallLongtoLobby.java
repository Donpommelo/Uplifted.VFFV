package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;


import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class WarpSouthHallLongtoLobby extends Event {


	public WarpSouthHallLongtoLobby(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
		
	}
		
	public void run(){
		if(super.getSwitch(2)){
			super.transport("/Worlds/Floor3Offices/SouthWingOffices/PostJorgeLobby.txt", 15, 8,"South Lobby");
		}
		else{
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"Hmm. Odd. This door appears to be blocked on the other side./ I think someone propped up some furniture against it. . ./");
			super.Dialog(d, 0, this.getId(), true);		}
	}
	
	public boolean isSolid(){
		return true;
	}

	public boolean isDoor(){
		return true;
	}
}