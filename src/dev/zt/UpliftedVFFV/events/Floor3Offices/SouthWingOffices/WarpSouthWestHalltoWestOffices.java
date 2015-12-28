package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;


import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class WarpSouthWestHalltoWestOffices extends Event {


	public WarpSouthWestHalltoWestOffices(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
	}
	
	public void run(){
		if(Event.events[66].isSelfswitch1()){
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"This door is locked from the other side./");
			super.Dialog(d, 0, this.getId(), true);
		}
	}


	public boolean isSolid(int i){
		return true;
	}

}
